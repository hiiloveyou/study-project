package com.chenyi.study;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.Key;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author chenyi
 * @date 2020/11/11
 */
public class ShiroTest {
    private static Subject subject;

    @BeforeAll
    static void beforeAll() {
        final Factory<SecurityManager> factory = new IniSecurityManagerFactory(
                "classpath:shiro-authenticator-authorizer.ini");
        final SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        subject = SecurityUtils.getSubject();
        final UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken();
        usernamePasswordToken.setUsername("chenyi1");
        usernamePasswordToken.setPassword("1234".toCharArray());

        try {
            subject.login(usernamePasswordToken);
            System.out.println("登陆成功");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        assertThat(subject.isAuthenticated()).isTrue();
    }

    @Test
    void testSubject() {
        subject.checkPermission("USER:LIST");
        assertThat(subject.hasRole("admin")).isTrue();
        assertThat(subject.isPermitted("USER:LIST")).isTrue();
        assertThat(subject.isAuthenticated()).isTrue();
    }

    @Test
    public void testAllSuccessfulStrategyWithSuccess() {
        //得到一个身份集合，其包含了Realm验证成功的身份信息
        PrincipalCollection principalCollection = subject.getPrincipals();
        assertThat(principalCollection.asList().size()).isEqualTo(1);
    }


    @AfterAll
    static void afterAll() {
        subject.logout();
        System.out.println("用户退出");
    }

    @Test
    void cryptography() {
        //Base64加密解密
        String password = "123";
        final String base64Encoded = Base64.encodeToString(password.getBytes());
        final String decodeToString = Base64.decodeToString(base64Encoded);
        assertThat(password).isEqualTo(decodeToString);

        //Hex加密解密
        String hexEncoded = Hex.encodeToString(password.getBytes());
        String hexDecoded = new String(Hex.decode(hexEncoded.getBytes()));
        assertThat(password).isEqualTo(hexDecoded);

        //byte和String转化
        //Charset.availableCharsets();
        final byte[] bytes = CodecSupport.toBytes(password, "utf-8");
        final String string = CodecSupport.toString(bytes);

        //加入盐，散列多次,Md5,SHA,SHA1,SHA512
        //Md5
        String salt = "qwe";
        final Md5Hash md5Hash = new Md5Hash(password, salt, 2);
        //SHA
        final Sha256Hash sha256Hash = new Sha256Hash(password, salt, 2);

        //默认算法SHA-512
        DefaultHashService hashService = new DefaultHashService();
        hashService.setHashAlgorithmName("SHA-512");
        //私盐，默认无
        hashService.setPrivateSalt(new SimpleByteSource("123"));
        //是否生成公盐，默认false
        hashService.setGeneratePublicSalt(true);
        //用于生成公盐。默认就这个
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());
        //生成Hash值的迭代次数
        hashService.setHashIterations(1);

        HashRequest request = new HashRequest.Builder()
                .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))
                .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();
        String hex = hashService.computeHash(request).toHex();
    }


    @Test
    void encodeDecode() {
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128); //设置key长度
        //生成key
        Key key = aesCipherService.generateNewKey();
        String text = "hello";
        //加密
        String encrptText = aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
        //解密
        String text2 = new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());
        assertThat(text).isEqualTo(text2);
    }

}

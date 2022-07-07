import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.util.MapperUtil;
import org.junit.jupiter.api.Test;
import service.inputDomain.Login;

import java.io.File;
import java.io.IOException;

/**
 * @Author: kong
 * @Date: 2022/7/6 15:57
 * @Description:
 */

public class TestCase {

    @Test
    void testLogin() throws IOException {
        MapperUtil<Login> mapperUtil = new MapperUtil<Login>();
        Login loginMapper = mapperUtil.getReadValue("src/test/resources/testData/login.yaml");

        System.out.println("Password:"+loginMapper.getPassword());
        System.out.println("Username:"+loginMapper.getUsername());
        System.out.println("Verification:"+loginMapper.getVerification());

    }

    @Test
    void test2() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        TypeReference<Login> typeReference = new TypeReference<>() {
        };
        Login loginMapper = objectMapper.readValue(new File("src/test/resources/testData/login.yaml"), typeReference);
        System.out.println("Password:"+loginMapper.getPassword());
        System.out.println("Username:"+loginMapper.getUsername());
        System.out.println("Verification:"+loginMapper.getVerification());
    }
}

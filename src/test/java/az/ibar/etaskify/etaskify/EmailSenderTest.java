package az.ibar.etaskify.etaskify;


import az.ibar.etaskify.etaskify.util.EmailSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailSenderTest {
    @Autowired
    private EmailSender emailSender;

    @Test
    public void testEmail() {
        emailSender.sendMail("jhasanov2019@gmail.com", "Test subject", "Test mail");
    }

}

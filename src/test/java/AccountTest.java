
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class AccountTest {

    private String name;
    private boolean answer;
    private static String testName;

    public AccountTest(String name, boolean answer, String testName) {
        this.name = name;
        this.answer = answer;
        this.testName = testName;
    }


    @Parameterized.Parameters (name = "{2}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Brendan Kutch",true, "латиница"},
                {"Стен Комаров",true, "кириллица"},
                {"Стен20 Ком4аров",true, "цифры в имени"},
                {"B r",true, "три символа в имени"},
                {"12 3",true, "только цифры, 4 символа"},
                {"Brendan Kutchenerov",true, "19 символов в строке"},
                {"Brendan",false, "нет пробела в строке"},
                {"Brendan  Kutch",false, "два пробела рядом в строке"},
                {"Brendan Kut ch",false, "два пробела не рядом строке"},
                {"Brendan Kutchenerove",false, "20 символов в строке"},
                {"Br",false, "2 символа в строке"},
                {" Стен Комаров",false, "пробел в начале строки"},
                {"Стен Комаров ",false, "пробел в конце строки"},
        };
    }


    @Test
    @DisplayName("Checking the name verification method: checkNameToEmboss")
    @Description("In test are represented a variety of names, that should be checked and filtered.")
    public void testCheckNameToEmboss() {

        Account account = new Account(name);

        Assert.assertEquals(account.checkNameToEmboss(),answer);
    }
}

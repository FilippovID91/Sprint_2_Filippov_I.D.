package practikum.filippov;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    @Test
    public void getSound() {
        Cat cat = new Cat(feline);
        String actualFamily = cat.getSound();
        String expectedFamily = "Мяу";
        Assert.assertEquals(expectedFamily, actualFamily);
    }

    @Mock
    Feline feline;

    @Test
    public void getFoodMockTest() throws Exception {
        feline.getFood("Тест");
        Mockito.verify(feline).getFood(Mockito.anyString());
    }
}

package practikum.filippov;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    @Test
    public void getSound() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String actualFamily = cat.getSound();
        String expectedFamily = "Мяу";
        Assert.assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> food = cat.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Mock
    Feline feline;

    @Test
    public void getFoodMockTest() throws Exception {
        feline.getFood("Тест");
        Mockito.verify(feline).getFood(Mockito.anyString());
    }
}

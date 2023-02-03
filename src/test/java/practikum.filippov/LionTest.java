package practikum.filippov;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {

    @Test
    public void haveManeTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        boolean mane = lion.doesHaveMane();
        Assert.assertFalse(mane);
    }

    @Test
    public void haveManeKingTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        boolean mane = lion.doesHaveMane();
        Assert.assertTrue(mane);
    }

    @Test
    public void haveManeExceptionTest() {
        try {
            Lion lion = new Lion("детеныш", feline);
            boolean mane =  lion.doesHaveMane();
            Assert.assertTrue(mane);
        }
        catch (Exception exception) {
            Assert.assertEquals(exception.getMessage(),"Используйте допустимые значения пола животного - самец или самка");
        }
    }

    @Test
    public void getKittensTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        int actualKittens =  lion.getKittens();
        int expectedKittens =  1;
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        List<String> actualFood = lion.getFood();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Mock
    Feline feline;

    @Test
    public void getKittensMockTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittens = 1;
        int actualKittens = lion.getKittens();
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void getFoodMockTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }
}
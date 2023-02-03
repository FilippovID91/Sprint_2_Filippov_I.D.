package practikum.filippov;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        String expectedFamily = "Кошачьи";
        Assert.assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = new Feline();
        List<String> actualFood = feline.getFood("Хищник");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFood, actualFood);
    }
    @Test
    public void getFoodExceptionTest() {
        try {Feline feline = new Feline();
            List<String> actualFood = feline.getFood("Собака");
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);}
        catch (Exception exception) {
            Assert.assertEquals(exception.getMessage(), "Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }

    @Test
    public void getFoodAnimalTest() throws Exception {
        Animal animal = new Animal();
        List<String> actualFood = animal.getFood("Травоядное");
        List<String> expectedFood = List.of("Трава", "Различные растения");
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFamilyAnimalTest()  {
        Animal animal = new Animal();
        String actualFamily = animal.getFamily();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> actualFood = feline.eatMeat();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens();
        int expectedKittens = 1;
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    @Mock
    Feline feline;

    @Test
    public void getKittensMockTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        Assert.assertEquals(expectedKittens, actualKittens);
    }
    @Mock
    Animal animal;
    @Test
    public void getFoodMockTest() throws Exception {
        animal.getFood("Собака");
        Mockito.verify(animal).getFood(Mockito.anyString());
    }
}
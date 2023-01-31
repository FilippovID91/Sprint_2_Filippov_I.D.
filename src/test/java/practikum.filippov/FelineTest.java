package practikum.filippov;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
    public void getKittensTest() {
        Feline feline = new Feline();
        int actualFamily = feline.getKittens();
        int expectedFamily = 1;
        Assert.assertEquals(expectedFamily, actualFamily);
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

    @RunWith(Parameterized.class)
    public static class getKittens {
        Feline feline = new Feline();
        private final int kittensCount;
        private final int expected;

        public getKittens(int kittensCount, int expected) {
            this.kittensCount = kittensCount;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[][] getKittensValues() {
            return new Object[][]{
                    {2, 2},
                    {3, 3},
                    {4, 4},
            };
        }

        @Test
        public void getKittensParamsTest() throws Exception {
            int actualKittens = feline.getKittens(kittensCount);
            Assert.assertEquals(expected, actualKittens);
        }
    }
}
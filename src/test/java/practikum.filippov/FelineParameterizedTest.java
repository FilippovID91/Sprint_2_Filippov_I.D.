package practikum.filippov;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class FelineParameterizedTest {

    @RunWith(Parameterized.class)
    public static class getKittensParameterizedTest {
        Feline feline = new Feline();
        private final int kittensCount;
        private final int expected;

        public getKittensParameterizedTest(int kittensCount, int expected) {
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
# Ping Pong TDD

*Ping pong* is one of the most basic activities used when teaching Test Driven Development (TDD) . The rules are simple:

- Work in pairs
- Person A only writes tests (test code only)
- Person B only tries to get the tests to pass (production code only)
- Both persons refactor when appropriate

During the activity, it a good idea to ask participants to switch roles. Person B becomes the test writer, and Person A becomes the test taker (or the person who gets the tests to pass).

This Lab shows how TDD can be easy and fun by combining it with pair programming. As if you were playing table tennis, in ping pong TDD you create a test for your partner to pass, and then he creates one for you.

 

This exercise is to create a unit of code that converts Roman numbers into Arabic numerals. Were going to show how the development proceeds when we work in the smallest possible increments

Player 1:

```
@Test
public void testNumber1() {
    assertEquals(1,RomanConverter.Convert("I"));
}

```

Player 2:

```
public class RomanConverter {
        public static int Convert(String s) 
        {
            return 1;
        }
}

@Test
public void testNumber2() {
    assertEquals(2,RomanConverter.Convert("II"));
}

```

Player 1:

```
public class RomanConverter {
    public static int Convert(String s) 
    {
        return s.length();
    }
}

@Test
public void testNumber5() {
    assertEquals(5,RomanConverter.Convert("V"));
}

```

Player 2:

```
public class RomanConverter {
    public static int Convert(String s) 
    {
        if (s.equals("V")){
            return 5;
        }
        else {
            return s.length();
        }
    }
}

@Test
public void testTwoDifferentNumbers() {
    assertEquals(6,RomanConverter.Convert("VI"));
}

```

Player 1:

```
public class RomanConverter {
    public static int Convert(String s) 
    {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                sum += 1;
            }
            else {
                sum+= 5;
            }
        }
    return sum;
   }
}


@Test
public void testSmallchar() {
    assertEquals(6,RomanConverter.Convert("vi"));
}

```

Continue until the final solution

- Solution can use Regex to check for 4 characters in a row
- Test case should make use of  JUnit 5 features - CsvSource, ParameterizedTest and assertThrows
- JUnit 5 guide can be found at http://junit.org/junit5/docs/current/user-guide/

# 

# Roman Numeral Rules

 

| **Symbol**                           | **Meaning**                              | **Decimal**                              |
| ------------------------------------ | ---------------------------------------- | ---------------------------------------- |
| [**I**](http://changelog.ca/topic/I) | [**One**](http://changelog.ca/topic/One) | [**1**](http://changelog.ca/topic/1)     |
| [**V**](http://changelog.ca/topic/V) | [**Five**](http://changelog.ca/topic/Five) | [**5**](http://changelog.ca/topic/5)     |
| [**X**](http://changelog.ca/topic/X) | [**Ten**](http://changelog.ca/topic/Ten) | [**10**](http://changelog.ca/topic/10)   |
| [**L**](http://changelog.ca/topic/L) | [**Fifty**](http://changelog.ca/topic/Fifty) | [**50**](http://changelog.ca/topic/50)   |
| [**C**](http://changelog.ca/topic/C) | [**One Hundred**](http://changelog.ca/topic/One%20Hundred) | [**100**](http://changelog.ca/topic/100) |
| [**D**](http://changelog.ca/topic/D) | [**Five Hundred**](http://changelog.ca/topic/Five%20Hundred) | [**500**](http://changelog.ca/topic/500) |
| [**M**](http://changelog.ca/topic/M) | [**One Thousand**](http://changelog.ca/topic/One%20Thousand) | [**1000**](http://changelog.ca/topic/1000) |

 

Roman numerals follow this pattern:

| **Units**     | **I** | **II** | **III** | **IV** | **V** | **VI** | **VII** | **VIII** | **IX** |
| ------------- | ----- | ------ | ------- | ------ | ----- | ------ | ------- | -------- | ------ |
| **Tens**      | **X** | **XX** | **XXX** | **XL** | **L** | **LX** | **LXX** | **LXXX** | **XC** |
| **Hundreds**  | **C** | **CC** | **CCC** | **CD** | **D** | **DC** | **DCC** | **DCCC** | **CM** |
| **Thousands** | **M** | **MM** | **MMM** | **IV** | **V** | **VI** | **VII** | **VIII** | **IX** |

 

**The Additive System**

The system for writing Roman numerals is an additive system. This means to calculate the value of a Roman numeral, you simply to have to add up all the digits in the Roman numeral.

Roman Numerals are always written from Largest to Smallest – Left to Right.

#### Examples:

VIII = 5 + 1 + 1 + 1 = 8

XXXIII = 10 + 10 + 10 + 1 + 1 + 1 = 33

CLXXVIII = 100 + 50 + 10 + 10 + 5 + 1 + 1 + 1 = 178

MMX = 1,000 + 1,000 + 10 = 2,010
**SUBTRACTIVE SYSTEM**You can write **one** smaller numeral to the left of a larger one to subtract from it! The table below has all the allowed subtractive combinations

| **Roman Numeral** | **Value** | **Equivalent** |
| ----------------- | --------- | -------------- |
| **IV**            | **4**     | **IIII**       |
| **IX**            | **9**     | **VIIII**      |
| **XL**            | **40**    | **XXXX**       |
| **XC**            | **90**    | **LXXXX**      |
| **CD**            | **400**   | **CCCC**       |
| **CM**            | **900**   | **DCCCC**      |

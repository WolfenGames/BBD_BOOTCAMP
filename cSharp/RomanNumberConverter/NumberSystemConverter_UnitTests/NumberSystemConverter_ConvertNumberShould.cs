using System;
using NumberSystemConverter;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace NumberSystemConverter_UnitTests
{
    [TestClass]
    public class NumberSystemConverter_ConverNumberShould
    {
        [TestMethod]
        public void ThrowIndexOutOfRangeWhenInputGreaterThan3000()
        {
            var converter = new RomanNumeralConverter();

            Assert.ThrowsException<IndexOutOfRangeException>(() => converter.ConvertNumber(3001));
        }

        [TestMethod]
        public void ReturnWhenInputIs1()
        {
            var converter = new RomanNumeralConverter();

            Assert.AreEqual("I", converter.ConvertNumber(1));
        }

        [TestMethod]
        public void ReturnWhenInputIs5()
        {
            var converter = new RomanNumeralConverter();

            Assert.AreEqual("V", converter.ConvertNumber(5));
        }

        [TestMethod]
        public void ReturnWhenInputIs100()
        {
            var converter = new RomanNumeralConverter();

            Assert.AreEqual("C", converter.ConvertNumber(100));
        }

        [TestMethod]
        public void ReturnWhenInputIs6()
        {
            var converter = new RomanNumeralConverter();

            Assert.AreEqual("VI", converter.ConvertNumber(6));
        }

        [TestMethod]
        public void ReturnWhenInputIs4()
        {
            var converter = new RomanNumeralConverter();

            Assert.AreEqual("IV", converter.ConvertNumber(4));
        }

        [TestMethod]
        public void Number_Equal_ThreeThousand_Expected_Result_MMM_TestMethod()
        {
            var converter = new RomanNumeralConverter();
            var result = converter.ConvertNumber(3000);

            Assert.AreEqual(result, "MMM");
        }

        [TestMethod]
        public void MichaelAndJulianTest()
        {
            var converter = new RomanNumeralConverter();

            Assert.AreEqual("MMCDLXIII", converter.ConvertNumber(2463));
        }

        [TestMethod]
        public void Number_Equal_500_Expected_Result_D_TestMethod()
        {
            var converter = new RomanNumeralConverter();
            var result = converter.ConvertNumber(500);

            Assert.AreEqual(result, "D");
        }

        [TestMethod]
        public void Number_Equal_599_Expected_Result_DLXXXXVIIII_TestMethod()
        {
            var converter = new RomanNumeralConverter();
            var result = converter.ConvertNumber(599, false);

            Assert.AreEqual(result, "DLXXXXVIIII");
        }

        [TestMethod]
        public void Number_Equal_2013_Expected_Result_MMXIII_TestMethod()
        {
            var converter = new RomanNumeralConverter();
            var result = converter.ConvertNumber(2013, false);

            Assert.AreEqual(result, "MMXIII");
        }

        [TestMethod]
        public void String_Equal_I_TestMethod(){
            var converter = new RomanNumeralConverter();

            var result = converter.RomanToArabic("I");

            Assert.AreEqual(1, result);
        }

        [TestMethod]
        public void String_Equal_MMCDLXIII_TestMethod(){
            var converter = new RomanNumeralConverter();

            var result = converter.RomanToArabic("MMCDLXIII");

            Assert.AreEqual(2463, result);
        }
    }
}
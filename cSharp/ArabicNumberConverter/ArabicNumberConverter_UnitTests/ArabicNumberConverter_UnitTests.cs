using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ArabicNumberConverter;

namespace ArabicNumberConverter_UnitTests
{
    [TestClass]
    public class ArabicNumberConverter_UnitTest
    {
        [TestMethod]
        public void ReturnIfIEquals1()
        {
            var converter = new ArabicConverter();

            Assert.IsEqual(1, converter.RomanToArabic("I"));
        }
    }
}

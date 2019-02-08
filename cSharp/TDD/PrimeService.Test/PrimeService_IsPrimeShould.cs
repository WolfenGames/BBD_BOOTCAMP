using Xunit;
using Prime.Service;
using System.Collections.Generic;

namespace Prime.UnitTest.Service
{
    public static class DemoPropertyDataSource
    {
        private static readonly List<object[]> _data
            = new List<object[]>
                {
                    new object[] {0},
                    new object[] {1},
                    new object[] {2},
                    new object[] {3},
                    new object[] {4},
                    new object[] {5},
                    new object[] {6},
                    new object[] {7},
                    new object[] {8},
                    new object[] {9},
                    new object[] {10},
                    new object[] {11},
                    new object[] {12},
                    new object[] {452930477},
                    new object[] {982451653}
                };

        public static IEnumerable<object[]> TestData
        {
            get { return _data; }
        }
    }
    public class PrimeService_IsPrimeShould
    {
        private readonly PrimeService _primeService;
        public PrimeService_IsPrimeShould()
        {
            _primeService = new PrimeService();
        }

        [Theory]
        [MemberData("TestData", MemberType = typeof(DemoPropertyDataSource))]

        public void ReturnTrueForPrime(int value)
        {
            var result = _primeService.IsPrime(value);
            if (!result) return;
            Assert.True(result, $"{value} should not be prime");
        }

        [Theory]
        [MemberData("TestData", MemberType = typeof(DemoPropertyDataSource))]

        public void ReturnFalseForNotPrime(int value)
        {
            var result = _primeService.IsPrime(value);
            if (result) return;
            Assert.False(result, $"{value} should be prime");
        }

        [Theory]
        [MemberData("TestData", MemberType = typeof(DemoPropertyDataSource))]
        public void ReturnTrueIfEven(int value)
        {
            var result = _primeService.IsEven(value);
            if (result) return;
            Assert.False(result, $"{value} is not even!!");
        }

        [Theory]
        [MemberData("TestData", MemberType = typeof(DemoPropertyDataSource))]
        public void ReturnFalseIfNotEven(int value)
        {
            var result = _primeService.IsEven(value);
            if (!result) return;
            Assert.False(result, $"{value} is Even");
        }

    }
}
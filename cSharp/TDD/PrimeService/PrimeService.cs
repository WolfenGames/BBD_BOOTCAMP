using System;

namespace Prime.Service
{
    public class PrimeService
    {
        public bool IsPrime(int candidate) {
            int i = (int)Math.Sqrt(candidate);

            if (candidate < 0) return false;
            if (candidate == 2) return true;
            while (i >= 2) {
                if (candidate % i == 0)
                    return (false);
                i--;
            }
            return (true);
            // throw new NotImplementedException("Oi!, use me you fat fuck!");
        }

        public bool IsEven(int candidate) {
            return (candidate % 2 == 0);
        }
    }
}

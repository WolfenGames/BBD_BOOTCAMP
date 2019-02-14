package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RomanToArabic {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/romantoarabic")
    public RomanConverterController romanToArabic(@RequestParam(value = "roman", defaultValue = "I") String roman) {
        return new RomanConverterController(counter.incrementAndGet(), RomanConverter.convert(roman), roman);
    }

    @RequestMapping("/arabicroroman")
    public ArabicToRomanController arabicToRoman(@RequestParam(value = "arabic", defaultValue = "1") int arabic) {
        return new ArabicToRomanController(counter.incrementAndGet(), RomanConverter.convertBack(arabic, true));
    }
}

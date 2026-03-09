package pl.dmcs.rkotas.task2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.rkotas.task2.model.Mathematics;

import static java.lang.Math.sqrt;

@Controller
public class MathController {

    @RequestMapping("/math")
    public String math(Model model) {
        model.addAttribute("message", "Calculate your stuff!");
        Mathematics newMath = new Mathematics();
        model.addAttribute("math", newMath);
        return "math";
    }

    @RequestMapping(value = "/calculatex1x2.html", method = RequestMethod.POST)
    public String calculatex1x2(@ModelAttribute("math") Mathematics mathematics) {
        double a = mathematics.getCoeffa();
        double b = mathematics.getCoeffb();
        double c = mathematics.getCoeffc();

        if (a == 0) {
            System.out.println("This is a linear function.");
            return "redirect:math";
        }

        mathematics.setDelta((b * b) - (4 * a * c));
        double delta = mathematics.getDelta();
        mathematics.setx1(((b * -1) - sqrt(delta)) / (2 * a));
        if (delta < 0) {
            System.out.println("There are no real roots.");
        } else if (delta == 0) {
            System.out.println("One root, x1 = " + mathematics.getx1());
        } else {
            mathematics.setx2(((b * -1) + sqrt(delta)) / (2 * a));
            System.out.printf("Two roots, x1 = %f, x2 = %f%n", mathematics.getx1(), mathematics.getx2());
        }

        return "redirect:math";
    }

    @RequestMapping(value = "/calculatefibonacci.html", method = RequestMethod.POST)
    public String calculatefibonacci(@ModelAttribute("math") Mathematics mathematics) {
        long n = mathematics.getFibonacciN();
        if (n <= 0) {
            System.out.println("0");
            return "redirect:math";
        }
        long a = 0, b = 1;
        for (long i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println(b);
        return "redirect:math";
    }
}

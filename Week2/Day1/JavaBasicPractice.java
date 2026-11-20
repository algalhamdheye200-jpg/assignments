// Java Basics Practice - Week 2 Day 1 (Q1 to Q15)
// Each question is a static method. main() runs all of them and prints results.
public class JavaBasicPractice {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("== Level 1 ==");
        q1Reverse();
        q2Casting();
        q3VowelsConsonants();
        q4Wrappers();
        q5Anagram();

        System.out.println("\n== Level 2 ==");
        q6Swap();
        q7PassByValue();
        q8RemoveDuplicates();
        q9FirstNonRepeated();
        q10StringOutput();

        System.out.println("\n== Level 3 ==");
        System.out.println("Q11: " + q11LongestUnique("abcabcbb") + " " + q11LongestUnique("pwwkew") + " " + q11LongestUnique(""));
        System.out.println("Q12: " + q12Compress("aaabbccccd") + " " + q12Compress("abc") + " " + q12Compress("a"));
        System.out.println("Q13: [" + q13ReverseWords("  Java is   easy to learn  ") + "]");
        q14Threads();
        q15Salary();
        System.out.println("Bonus: " + longestPalindrome("babad"));
    }

    // ---------------- Level 1 ----------------

    // Q1: reverse an int without a String. Uses long so reversing can't overflow int.
    static void q1Reverse() {
        System.out.println("Q1:");
        System.out.println(reverseInt(12345) + " " + reverseInt(908) + " " + reverseInt(-120));
    }

    static long reverseInt(int n) {
        long number = n;
        boolean negative = number < 0;
        if (negative) {
            number = -number;
        }
        long reversed = 0;
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return negative ? -reversed : reversed;
    }

    // Q2: casting. Expected output: 13, 70, F
    static void q2Casting() {
        System.out.println("Q2:");
        int a = 10;
        double b = 3.5;
        int result = (int) (a + b);          // narrowing: 13.5 -> 13
        System.out.println(result);
        char ch = 'A';
        int value = ch + 5;                  // 'A' is 65 -> 70
        System.out.println(value);
        System.out.println((char) value);    // 70 -> 'F'
        // Implicit (widening): int -> double. Explicit (narrowing): double -> int.
        double implicit = a;
        System.out.println("implicit: " + implicit + ", explicit: " + (int) b);
    }

    // Q3: count vowels and consonants, ignoring non-letters.
    static void q3VowelsConsonants() {
        System.out.println("Q3:");
        String text = "Programming";
        int vowels = 0, consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);         // 3
        System.out.println("Consonants: " + consonants); // 8
    }

    // Q4: String -> wrapper classes, 10% increment, invalid input handled.
    static void q4Wrappers() {
        System.out.println("Q4:");
        String age = "25";
        String salary = "45000.75";
        String active = "true";
        try {
            Integer ageValue = Integer.valueOf(age);            // parse to wrapper
            Double salaryValue = Double.valueOf(salary);
            Boolean activeValue = Boolean.valueOf(active);
            double increased = salaryValue * 1.10;               // 10% increment
            System.out.println("Age: " + ageValue + " (" + ageValue.getClass().getSimpleName() + ")");
            System.out.println("Salary: " + salaryValue + " (" + salaryValue.getClass().getSimpleName() + ")");
            System.out.println("Active: " + activeValue + " (" + activeValue.getClass().getSimpleName() + ")");
            System.out.println("Salary after 10%: " + increased);
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input: " + e.getMessage());
        }
        try {
            Integer.valueOf("abc");
        } catch (NumberFormatException e) {
            System.out.println("Handled invalid input: " + e.getMessage());
        }
    }

    // Q5: anagram check using letter counts. Ignores case and spaces.
    static void q5Anagram() {
        System.out.println("Q5:");
        System.out.println(isAnagram("listen", "silent") ? "Anagram" : "Not Anagram");
        System.out.println(isAnagram("hello", "world") ? "Anagram" : "Not Anagram");
    }

    static boolean isAnagram(String a, String b) {
        int[] counts = new int[26];
        for (char c : a.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') counts[c - 'a']++;
        }
        for (char c : b.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') counts[c - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }

    // ---------------- Level 2 ----------------

    // Q6: swap without a third variable, arithmetic and XOR versions.
    static void q6Swap() {
        System.out.println("Q6:");
        int a = 10, b = 20;
        // Arithmetic version can overflow when the sum exceeds int range; XOR does not.
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + ", b = " + b);   // a = 20, b = 10
        int x = 10, y = 20;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("XOR: x = " + x + ", y = " + y); // x = 20, y = 10
    }

    // Q7: pass by value. Primitives copy the value; references copy the reference.
    static void q7PassByValue() {
        System.out.println("Q7:");
        int a = 10;
        int[] numbers = {10, 20, 30};
        modify(a);
        modifyArray(numbers);
        System.out.println(a);          // 10: the method changed only its copy
        System.out.println(numbers[0]); // 100: the method changed the shared array
        replaceArray(numbers);
        System.out.println(numbers[0]); // still 100: the parameter pointed at a new array
    }

    static void modify(int x) { x = 100; }
    static void modifyArray(int[] arr) { arr[0] = 100; }
    static void replaceArray(int[] arr) { arr = new int[]{999, 999, 999}; }

    // Q8: remove duplicates, keep first occurrence. Only nested loops, no Set/Map.
    static void q8RemoveDuplicates() {
        System.out.println("Q8:");
        String input = "programming";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            boolean seenBefore = false;
            for (int j = 0; j < i; j++) {
                if (input.charAt(j) == c) {
                    seenBefore = true;
                    break;
                }
            }
            if (!seenBefore) sb.append(c);
        }
        System.out.println(sb); // progamin
    }

    // Q9: first non-repeated character, nested loops.
    static void q9FirstNonRepeated() {
        System.out.println("Q9:");
        System.out.println(firstNonRepeated("swiss"));  // w
        System.out.println(firstNonRepeated("aabbcc"));
    }

    static String firstNonRepeated(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean repeated = false;
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    repeated = true;
                    break;
                }
            }
            if (!repeated) return String.valueOf(s.charAt(i));
        }
        return "No non-repeated character";
    }

    // Q10: string identity. Expected: true, false, true, Java Programming, Java
    static void q10StringOutput() {
        System.out.println("Q10:");
        String s1 = "Java";
        String s2 = "Java";              // same pooled object
        String s3 = new String("Java");  // new object on the heap
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");       // mutates the same builder object
        System.out.println(sb);
        System.out.println(s1);          // original String unchanged: immutable
    }

    // ---------------- Level 3 ----------------

    // Q11: longest substring without repeating characters, sliding window, O(n).
    static int q11LongestUnique(String s) {
        int[] lastSeen = new int[65536];   // index + 1 of each char's last occurrence
        int best = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastSeen[c] > start) {
                start = lastSeen[c];       // move window past the previous occurrence
            }
            lastSeen[c] = i + 1;
            best = Math.max(best, i + 1 - start);
        }
        return best;
    }

    // Q12: run-length compression with StringBuilder.
    static String q12Compress(String s) {
        if (s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        return sb.toString();
    }

    // Q13: reverse word order without split(), handles extra spaces.
    static String q13ReverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int end = s.length() - 1;
        while (end >= 0) {
            while (end >= 0 && s.charAt(end) == ' ') end--;          // skip spaces
            if (end < 0) break;
            int start = end;
            while (start >= 0 && s.charAt(start) != ' ') start--;    // find word start
            if (result.length() > 0) result.append(' ');
            result.append(s, start + 1, end + 1);                    // copy word as-is
            end = start;
        }
        return result.toString();
    }

    // Q14: two threads appending to one StringBuilder (unsafe) vs one StringBuffer (synchronized).
    static void q14Threads() throws InterruptedException {
        System.out.println("Q14:");
        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();
        Thread b1 = new Thread(() -> { for (int i = 0; i < 1000; i++) builder.append("a"); });
        Thread b2 = new Thread(() -> { for (int i = 0; i < 1000; i++) builder.append("b"); });
        Thread f1 = new Thread(() -> { for (int i = 0; i < 1000; i++) buffer.append("a"); });
        Thread f2 = new Thread(() -> { for (int i = 0; i < 1000; i++) buffer.append("b"); });
        b1.start(); b2.start(); b1.join(); b2.join();
        f1.start(); f2.start(); f1.join(); f2.join();
        System.out.println("StringBuilder length (can be under 2000 because of races): " + builder.length());
        System.out.println("StringBuffer length (always 2000): " + buffer.length());
        // StringBuffer methods are synchronized, so only one thread changes it at a time.
        // StringBuilder is faster but not safe for shared use across threads.
    }

    // Q15: employee salary processing.
    static void q15Salary() {
        System.out.println("Q15:");
        int employeeId = 101;
        String name = "Rahul";
        String salaryText = "60000";
        int bonusPercent = 20;
        boolean active = true;
        try {
            double basic = Double.parseDouble(salaryText);     // String -> number
            double bonus = basic * bonusPercent / 100.0;
            double finalSalary = basic + bonus;
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Employee Name: " + name.toUpperCase());
            System.out.println("Basic Salary: " + basic);
            System.out.println("Bonus: " + bonus);
            System.out.println("Final Salary: " + finalSalary);
            System.out.println("Active: " + active);
            System.out.println("Reversed Name: " + new StringBuilder(name).reverse());
            System.out.println("Salary above 75000: " + (finalSalary > 75000 ? "Yes" : "No"));
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary input: " + salaryText);
        }
        // Reference demo: two variables can share one object; a new object is independent.
        StringBuilder ref = new StringBuilder("Rahul");
        StringBuilder same = ref;                    // same object
        StringBuilder copy = new StringBuilder(ref); // new object with same content
        same.append("!");
        System.out.println(ref + " | " + same + " | " + copy); // Rahul! | Rahul! | Rahul
    }

    // Bonus: longest palindromic substring, expand around centers.
    static String longestPalindrome(String s) {
        int bestStart = 0, bestLen = 0;
        for (int center = 0; center < s.length(); center++) {
            for (int k = 0; k < 2; k++) {
                int lo = center, hi = center + k;
                while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
                    lo--;
                    hi++;
                }
                int len = hi - lo - 1;
                if (len > bestLen) {
                    bestLen = len;
                    bestStart = lo + 1;
                }
            }
        }
        return s.substring(bestStart, bestStart + bestLen);
    }
}

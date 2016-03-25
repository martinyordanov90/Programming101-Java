package week06;

import java.util.ArrayList;
import java.util.List;

public class UserInputChecker {
    interface Validator {
        boolean validate(String input);
    }

    public class PersonNameValidator implements Validator {
        @Override
        public boolean validate(String input) {
            return input.matches("\\w+");
        }
    }

    public class BulgarianPhoneNumberValidator implements Validator {
        @Override
        public boolean validate(String input) {
            if (input.charAt(0) != '+') {
                return false;
            }
            input = input.replaceFirst("+", "");

            try {
                int number = Integer.valueOf(input);
            } catch(NumberFormatException e) {
                return false;
            }

            if (input.substring(0, 2) != "359") {
                return false;
            }

            if (input.length() != 12) {
                return false;
            }

            return true;
        }
    }

    public class PersonAgeValidator implements Validator {
        @Override
        public boolean validate(String input) {
            try {
                int age = Integer.MIN_VALUE;
                age = Integer.valueOf(age);
                if (age < 1 || age > 123) {
                    return false;
                }
                return true;
            } catch(NumberFormatException e) {
                return false;
            }
        }
    }

    public class CreditCardNumberValidator implements Validator {
        @Override
        public boolean validate(String input) {
            try {
                int number = Integer.valueOf(input);
                List<Integer> digits = new ArrayList<>();
                while (number > 0) {
                    digits.add(number % 10);
                    number /= 10;
                }

                for (int i = 0; i < digits.size(); i += 2) {
                    int curr = digits.remove(i);
                    digits.add(i, curr * 2);
                }

                int sum = digits.stream().reduce(0, (a, b) -> a + b);
                int checkDigit = (sum * 9) % 10;
                sum += checkDigit;

                return sum % 10 == 0;
            } catch(NumberFormatException e) {
                return false;
            }
        }
    }

    public class IpVersion4Validator implements Validator {
        @Override
        public boolean validate(String input) {
            String[] bytes = input.split(".");
            if (bytes.length != 4) {
                return false;
            }

            for (int i = 0; i < 4; i++) {
                try {
                    int curr = Integer.valueOf(bytes[i]);
                    if (curr < 0 || curr > 255) {
                        return false;
                    }
                } catch(NumberFormatException e) {
                    return false;
                }
            }

            return true;
        }
    }

    public class IpVersion6Validator implements Validator {
        @Override
        public boolean validate(String input) {
            String[] bytes = input.split(":");
            if (bytes.length != 8) {
                return false;
            }

            for (int i = 0; i < 8; i++) {
                try {
                    if (!bytes[i].matches("[0..9a..f]{4}")) {
                        return false;
                    }
                } catch(NumberFormatException e) {
                    return false;
                }
            }

            return true;
        }
    }

    public class MacAddressValidator implements Validator {
        @Override
        public boolean validate(String input) {
            String[] bytes = input.split(":");
            if (bytes.length != 6) {
                return false;
            }

            for (int i = 0; i < 6; i++) {
                try {
                    if (!bytes[i].matches("[0..9a..f]{2}")) {
                        return false;
                    }
                } catch(NumberFormatException e) {
                    return false;
                }
            }

            return true;
        }
    }
}

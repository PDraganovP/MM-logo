package logo;

import java.util.Scanner;

import static logo.ProgramConstants.*;

public class Logo {

    public Logo() {
    }

    public String inputCharacterWidth() {
        System.out.println(BASE_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);

        System.out.print(BASE_ASSIGNMENT_MESSAGE);
        String characterWidth = scanner.next();

        return characterWidth;
    }

    public int getCharacterWidthAfterValidation(String characterWidth) {
        Scanner scanner = new Scanner(System.in);
        boolean isNumber = isNumber(characterWidth);
        int characterWidthAfterValidation = 0;

        do {
            if (!isNumber) {
                System.out.println(BASE_IS_NUMBER_VALIDATION_MESSAGE);
                System.out.println(BASE_INPUT_MESSAGE);
                System.out.print(BASE_ASSIGNMENT_MESSAGE);
                characterWidth = scanner.next();
                if (isNumber(characterWidth)) {
                    isNumber = true;
                }
            }

            if (isNumber) {
                characterWidthAfterValidation = parseToInt(characterWidth);

                while ((characterWidthAfterValidation % 2 == 0) || !(2 < characterWidthAfterValidation && characterWidthAfterValidation < 10000)) {
                    if (characterWidthAfterValidation % 2 == 0) {
                        System.out.println(BASE_IS_ODD_VALIDATION_MESSAGE);
                        System.out.println(BASE_INPUT_MESSAGE);
                        System.out.print(BASE_ASSIGNMENT_MESSAGE);

                        characterWidth = scanner.next();
                        if (isNumber(characterWidth)) {
                            characterWidthAfterValidation = parseToInt(characterWidth);
                            isNumber = true;
                        } else {
                            isNumber = false;
                            break;
                        }
                    } else if (!(2 < characterWidthAfterValidation && characterWidthAfterValidation < 10000)) {
                        System.out.println(BASE_RANGE_VALIDATION_MESSAGE);
                        System.out.println(BASE_INPUT_MESSAGE);
                        System.out.print(BASE_ASSIGNMENT_MESSAGE);
                        characterWidth = scanner.next();
                        if (isNumber(characterWidth)) {
                            characterWidthAfterValidation = parseToInt(characterWidth);
                            isNumber = true;
                        } else {
                            isNumber = false;
                            break;
                        }
                    }
                }
            }
        } while (!isNumber);

        return characterWidthAfterValidation;
    }

    public void printMMLogo(int characterWidth, char emptySpaceSymbol, char characterSymbol) {
        printUpperPart(characterWidth, emptySpaceSymbol, characterSymbol);
        printBottomPart(characterWidth, emptySpaceSymbol, characterSymbol);
    }

    private int parseToInt(String number) {
        int parsedNumber = Integer.parseInt(number);
        return parsedNumber;
    }

    private boolean isNumber(String number) {
        char[] charArray = number.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!(Character.isDigit(charArray[i]))) {
                return false;
            }
        }
        return true;
    }

    private void printUpperPart(int characterWidth, char emptySpaceSymbol, char characterSymbol) {
        int count = (characterWidth + 1) / 2;
        int emptySpaceSymbolFirstTypeWidth = characterWidth;
        int characterSymbolFirstTypeWidth = characterWidth;
        int emptySpaceSymbolSecondTypeWidth = characterWidth;
        int numberOfTheSymbolChange = 10;

        while (0 < count) {
            for (int i = 1; i < numberOfTheSymbolChange + 1; i++) {
                switch (i) {
                    case 2:
                    case 4:
                    case 7:
                    case 9:
                        writeSymbolNTimes(characterSymbol, characterSymbolFirstTypeWidth);
                        break;
                    case 3:
                    case 8:
                        writeSymbolNTimes(emptySpaceSymbol, emptySpaceSymbolSecondTypeWidth);
                        break;
                    case 1:
                    case 6:
                        writeSymbolNTimes(emptySpaceSymbol, emptySpaceSymbolFirstTypeWidth);
                        break;
                    case 5:
                    case 10:
                        writeSymbolNTimes(emptySpaceSymbol, emptySpaceSymbolFirstTypeWidth);
                        break;
                }
            }
            System.out.println();

            count--;
            emptySpaceSymbolFirstTypeWidth--;
            characterSymbolFirstTypeWidth += 2;
            emptySpaceSymbolSecondTypeWidth -= 2;
        }

    }

    private void printBottomPart(int characterWidth, char emptySpaceSymbol, char characterSymbol) {
        int count = (characterWidth + 1) / 2;
        int characterSymbolFirstTypeWidth = characterWidth;
        int emptySpaceSymbolFirstTypeWidth = characterWidth / 2;
        int characterSymbolSecondTypeWidth = (characterWidth * 2) - 1;
        int emptySpaceSymbolSecondTypeWidth = 1;
        int numberOfTheSymbolChange = 14;

        while (0 < count) {
            for (int i = 1; i < numberOfTheSymbolChange + 1; i++) {
                switch (i) {
                    case 1:
                    case 7:
                    case 8:
                    case 14:
                        writeSymbolNTimes(emptySpaceSymbol, emptySpaceSymbolFirstTypeWidth);
                        break;
                    case 2:
                    case 6:
                    case 9:
                    case 13:
                        writeSymbolNTimes(characterSymbol, characterSymbolFirstTypeWidth);
                        break;
                    case 4:
                    case 11:
                        writeSymbolNTimes(characterSymbol, characterSymbolSecondTypeWidth);
                        break;
                    case 3:
                    case 5:
                    case 10:
                    case 12:
                        writeSymbolNTimes(emptySpaceSymbol, emptySpaceSymbolSecondTypeWidth);
                        break;
                }
            }
            System.out.println();

            count--;
            emptySpaceSymbolFirstTypeWidth--;
            characterSymbolSecondTypeWidth -= 2;
            emptySpaceSymbolSecondTypeWidth += 2;
        }
    }

    private void writeSymbolNTimes(char symbol, int numberOfRepetitions) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numberOfRepetitions; i++) {
            stringBuilder.append(symbol);
        }
        System.out.print(stringBuilder.toString());
    }
}



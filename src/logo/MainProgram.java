package logo;

public class MainProgram {
    public static void main(String[] args) {
        Logo logo = new Logo();
        String characterWidth = logo.inputCharacterWidth();
        int characterWidthAfterValidation = logo.getCharacterWidthAfterValidation(characterWidth);

        logo.printMMLogo(characterWidthAfterValidation, '-', '*');
    }
}

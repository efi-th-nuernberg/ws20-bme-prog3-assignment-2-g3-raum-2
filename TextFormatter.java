class TextFormatter {

  String formattedText;
  int firstPositionInLine;
  int lastPositionInLine;
  int lengthOfLine;

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text);
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    formattedText = "";
    firstPositionInLine = 0;
    lastPositionInLine = -1;
    lengthOfLine = maxLineLength;
  }

  // Ausgabe
  public void print(String aText) {
    while(lastPositionInLine < aText.length()){
      findNewLinePositions(aText);
      formattedText += formatLine(aText);
    } 
    System.out.println(formattedText);
  }

  public String formatLine(String aText){
    return(aText.substring(firstPositionInLine,lastPositionInLine)+"\n");
  }

  public void findNewLinePositions(String aText){
      firstPositionInLine = lastPositionInLine + 1;
      if(lastPositionInLine + lengthOfLine <= aText.length()){
        lastPositionInLine = findLastSpaceInFrontOfPosition(firstPositionInLine + lengthOfLine, aText);
      }else{
        lastPositionInLine = aText.length();
      }
  }

  public int findLastSpaceInFrontOfPosition(int position, String aText){
    char c = aText.charAt(position);
    while(c != ' '){
      if(position == 0) break;
      --position;
      c = aText.charAt(position);
    }
    return(position);
  }

  //Rechtsbündig
  public void printAlignedRight(String aText) {
    while(lastPositionInLine < aText.length()){
      findNewLinePositions(aText);
      formattedText += alignLineRight(formatLine(aText));
    } 
    System.out.println(formattedText);
  }

  public String alignLineRight(String aLine){
    while (aLine.length() < lengthOfLine) aLine = ' ' + aLine;
    return (aLine);
  }

  //Blocksatz
  public void printJustified(String aText){
    while(lastPositionInLine < aText.length()){
      findNewLinePositions(aText);
      formattedText += justifyLine(formatLine(aText));
    } 
    System.out.println(formattedText);
  }

  public String justifyLine(String aLine){
    int positionOfSpaces = aLine.indexOf(' ');
    while (aLine.length() < lengthOfLine){
      aLine = aLine.substring(0,positionOfSpaces)+ " "+ aLine.substring(positionOfSpaces,aLine.length());
    }
    return(aLine);
  }

}
class TextFormatter {

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
    String newtext = "";
    int position1 = 0;
    int position2 = maxLineLength-1;

    while(position2 < text.length()){
      newtext += text.substring(position1,positionOfLinebreak(position2))+"\n";
      position1 = positionOfLinebreak(position2)+1;
      position2 = position1+maxLineLength;
    }
    newtext += text.substring(position1,text.length())+"\n";  
    System.out.println(newtext);
  }

  public int positionOfLinebreak(int position){
    char c = text.charAt(position);

    while(c != ' '){
    --position;
    c = text.charAt(position);
    }
    return(position);
  }

  // Ausgabe
  public void print(String aText) {
    System.out.println(".");
  }
}
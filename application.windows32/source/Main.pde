void setup() {
  fullScreen();
  setup = new Setup();
  setup.setup();
}

//Goes through all the tests and updates mouse position
void draw() {
  setup.setup();
  noStroke();
  if (introPlayed == false) {
      dialogue.intro();
      introPlayed = true;
  }
  for (PShape shape : shapesInDrawingBoard) {
    shape(shape, 0, 0);        
  }
  
  for (PShape shape : shapesStuck) {
    shape(shape, 0, 0);        
  }
  
  checkonTest(); 
  checkOverTestRectangles();
  changeShapeColor();
  checkOnShape();
  checkTestStatus();
  checkforHelpButton();
  checkforRepeatButton();
  mouseMakeHand();
  mouseMakeFill(); 
  checkforSubmitButton();
  checkGameOver();
  test.checkTest1Repeat();
  test.checkTest2Repeat();
  test.checkTest3Repeat();
  test.checkTest4Repeat();
  test.checkTest5Repeat();
  test.checkTest6Repeat();
  test.checkTest7Repeat();
  test.checkTest8Repeat();
  test.checkTest9Repeat();
  test.checkTest10Repeat();
  checkforClear();
  whichTest();
  
}

//Checks if game is over
void checkGameOver() {
  if (livesLeft == 0) {
   dialogue.gameOver();
   exit();
  }
}

boolean checkonTest() {
  if ((ontest1 || ontest2 || ontest3 || ontest4 || ontest5 || ontest6 || ontest7 || ontest8 || ontest9 || ontest10) && (rect1Over || rect2Over || rect3Over || rect4Over || rect5Over || rect6Over || rect7Over || rect8Over || rect9Over || rect10Over)) {
    onTest = true;
  } else {
    onTest = false;
  }
  return onTest;
}

boolean whichTest() {
   if ((!ontest1 && !ontest2 && !ontest3 && !ontest4 && !ontest5 && !ontest6 && !ontest7 && !ontest8 && !ontest9 && !ontest10) && (rect1Over || rect2Over || rect3Over || rect4Over || rect5Over || rect6Over || rect7Over || rect8Over || rect9Over || rect10Over)) {
      if (level == 0 && rect1Over) {
        notOnTest = false;
      } else if (level == 1 && rect2Over){
        notOnTest = false;
      } else if (level == 2 && rect3Over){
        notOnTest = false;
      } else if (level == 3 && rect4Over){
        notOnTest = false;
      } else if (level == 4 && rect5Over){
        notOnTest = false;
      } else if (level == 5 && rect6Over){
        notOnTest = false;
      } else if (level == 6 && rect7Over){
        notOnTest = false;
      } else if (level == 7 && rect8Over){
        notOnTest = false;
      } else if (level == 8 && rect9Over){
        notOnTest = false;
      } else if (level == 9 && rect10Over){
        notOnTest = false;
      } else {
        notOnTest = true;
      }
   } else {
     notOnTest = false;
   }
   return notOnTest;
}


//Checks if the mouse is over the rectangle
void checkOverTestRectangles() {
  if (overRect(rect10x,recty,rectwidth,rectheight)) {
    rect10Over = true;
  } else if (overRect(rect9x,recty,rectwidth,rectheight)) {
    rect9Over = true;
  } else if (overRect(rect8x,recty,rectwidth,rectheight)) {
    rect8Over = true;
  } else if (overRect(rect7x,recty,rectwidth,rectheight)) {
    rect7Over = true;
  } else if (overRect(rect6x,recty,rectwidth, rectheight) ) {
    rect6Over = true;
  } else if (overRect(rect5x,recty,rectwidth,rectheight)) {
    rect5Over = true;
  } else if (overRect(rect4x,recty,rectwidth,rectheight)) {
    rect4Over = true;
  } else if (overRect(rect3x,recty,rectwidth,rectheight)) {
    rect3Over = true;
  } else if (overRect(rect2x,recty,rectwidth, rectheight) ) {
    rect2Over = true;
  } else if (overRect(rect1x, recty, rectwidth, rectheight)) {
    rect1Over = true;
  } else {
     rect10Over = false;
     rect9Over = false;
     rect8Over = false;
     rect7Over = false;
     rect6Over = false;
     rect5Over = false;
     rect4Over = false;
     rect3Over = false;
     rect2Over = false;
     rect1Over = false;
  }
}

//Changes colors of the shapes you can drag on canvas
void changeShapeColor() {
  if (overRect(colorWidth, 20, colorSize, colorSize)) {
    overRed = true;
  } else if (overRect(colorWidth, 170, colorSize, colorSize)) {
    overGreen = true;
  } else if (overRect(colorWidth, 320, colorSize, colorSize)) {
    overBlue = true;
  } else if (overRect(colorWidth, 470, colorSize, colorSize)) {
    overYellow = true;
  } else if (overRect(colorWidth, 620, colorSize, colorSize)) {
    overPink = true;
  } else if (overRect(colorWidth, 770, colorSize, colorSize)) {
    overOrange = true;
  } else {
    overRed = false;
    overGreen = false;
    overBlue = false;
    overYellow = false;
    overPink = false;
    overOrange = false;
  }
}

//Detects if mouse over clear button
void checkforClear() {
 if (overRect(clearButtonx, clearButtony, clearButtonwidth, clearButtonheight)) {
   overClear = true;
 } else {
   overClear = false;
 }
}

//Detects if the mouse is over clear button
void checkforHelpButton() {
  if (overRect(helpButtonX, helpButtonY , helpButtonSizeW, helpButtonSizeL)) {
    overHelp = true;
  } else {
    overHelp = false;
  }
}

void checkforSubmitButton() {
  if (overRect(submitButtonX, submitButtonY, submitButtonSizeW, submitButtonSizeL)) {
    overSubmit = true;
  } else {
    overSubmit = false;
  }
}

void checkforRepeatButton() {
  if(overRect(repeatButtonX, repeatButtonY, repeatButtonSizeW, repeatButtonSizeL)) {
    overRepeat = true;
  } else {
    overRepeat = false;
  }
}

//Checks if mouse is over a draggable shape
void checkOnShape() {
 if (overRect(SquareX, SquareY, SquareSize, SquareSize)) {
   overSqaure = true;
 } else if (overRect(RectangleX,RectangleY, RectangleW, RectangleH)) {
   overRectangle = true;
 } else if (overCircle(CircleX, CircleY, CircleSize)) {
   overCircle = true;
 } else {
   overSqaure = false;
   overRectangle = false;
   overCircle = false;
 }
}

void mouseMakeHand() {
  if (overSqaure || overRectangle || overCircle || overHelp || overRepeat || overClear || overSubmit || 
         overRed || overBlue || overGreen || overYellow || overPink || overOrange 
         || rect1Over || rect2Over || rect3Over || rect4Over || rect5Over || rect6Over || rect7Over || rect8Over || rect9Over || rect10Over) {
    cursor(HAND);
  } else {
    cursor(ARROW);
  }
}

void mouseMakeFill() {
  if (rect1Over) {
    fillColorTest1 = color (220,220,220);
  } else if (rect2Over) {
    fillColorTest2 = color (220,220,220);
  } else if (rect3Over) {
    fillColorTest3 = color (220,220,220);
  } else if (rect4Over) {
    fillColorTest4 = color (220,220,220);
  } else if (rect5Over) {
    fillColorTest5 = color (220,220,220);
  } else if (rect6Over) {
    fillColorTest6 = color (220,220,220);
  } else if (rect7Over) {
    fillColorTest7 = color (220,220,220);
  } else if (rect8Over) {
    fillColorTest8 = color (220,220,220);
  } else if (rect9Over) {
    fillColorTest9 = color (220,220,220);
  } else if (rect10Over) {
    fillColorTest10 = color (220,220,220);
  } else if (overHelp) {
    fillColorHelp = color (220,220,220);
  } else if (overSubmit) {
    fillColorSubmit = color (220,220,220);
  } else if (overHelp) {
    fillColorHelp = color (220,220,220);
  } else if (overRepeat) {
    fillColorRepeat = color (220,220,220);
  } else if (overClear) {
    fillColorClear = color (220,220,220);
  } else {
    fillColorTest1 = (255);
    fillColorTest2 = (255);
    fillColorTest3 = (255);
    fillColorTest4 = (255);
    fillColorTest5 = (255);
    fillColorTest6 = (255);
    fillColorTest7 = (255);
    fillColorTest8 = (255);
    fillColorTest9 = (255);
    fillColorTest10 = (255);
    fillColorClear = (255);
    fillColorSubmit = (255);
    fillColorHelp = (255);
    fillColorRepeat = (255);
       
  }
}

//Checks if player can enter a test or not
void checkTestStatus() {
 if (finishedTest10Setup == true && ontest10 == false) {
    dialogue.youWon();
    exit();
  } else if (test10 == true && finishedTest9Setup == true && finishedTest10Setup == false && ontest9 == false) {
    colors.clear();
    shapes.clear();
    test.test10();
    finishedTest10Setup = true;
  } else if (test9 == true && finishedTest8Setup == true && finishedTest9Setup == false && ontest8 == false) {
    colors.clear();
    shapes.clear();
    test.test9();
    finishedTest9Setup = true;
  } else if (test8 == true && finishedTest7Setup == true && finishedTest8Setup == false && ontest7 == false) {
    colors.clear();
    shapes.clear();
    test.test8();
    finishedTest8Setup = true;
  } else if (test7 == true && finishedTest6Setup == true && finishedTest7Setup == false && ontest6 == false) {
    colors.clear();
    shapes.clear();
    test.test7();
    finishedTest7Setup = true;
  } else if (test6 == true && finishedTest5Setup == true && finishedTest6Setup == false && ontest5 == false) {
    colors.clear();
    shapes.clear();
    test.test6();
    finishedTest6Setup = true;
  } else if (test5 == true && finishedTest4Setup == true && finishedTest5Setup == false && ontest4 == false) {
    colors.clear();
    shapes.clear();
    test.test5();
    finishedTest5Setup = true;
  } else if (test4 == true && finishedTest3Setup == true && finishedTest4Setup == false && ontest3 == false) {
    colors.clear();
    shapes.clear();
    test.test4();
    finishedTest4Setup = true;
  } else if (test3 == true && finishedTest2Setup == true && finishedTest3Setup == false && ontest2 == false) {
    colors.clear();
    shapes.clear();
    test.test3();
    finishedTest3Setup = true;
  } else if (test2 == true && finishedTest1Setup == true && finishedTest2Setup == false && ontest1 == false) {
    colors.clear();
    shapes.clear();
    test.test2();
    finishedTest2Setup = true;
  } else if (test1 == true && finishedTest1Setup == false) {
    colors.clear();
    shapes.clear();
    test.test1();
    finishedTest1Setup = true;
  } 
}

//Inacts a test if a the mouse is pressed over a certain shape
void mousePressed
() {
  if (rect10Over && finishedTest9Setup) {
    test10 = true;
  } else if (rect9Over && finishedTest8Setup) {
    test9 = true;
  } else if (rect8Over && finishedTest7Setup) {
    test8 = true;
  } else if (rect7Over && finishedTest6Setup) {
    test7 = true;
  } else if (rect6Over && finishedTest5Setup) {
    test6 = true;
  } else if (rect5Over && finishedTest4Setup) {
    test5 = true;
  } else if (rect4Over && finishedTest3Setup) {
    test4 = true;
  } else if (rect3Over && finishedTest2Setup) {
    test3 = true;
  } else if (rect2Over && finishedTest1Setup) {
    test2 = true;
  } else if (rect1Over) {
    test1 = true;
  } else if (overRed) {
    currentShapeColor = color(255,0,0);
    currentColor = "red";
  } else if (overGreen) {
    currentShapeColor = color(0,255,0);
    currentColor = "green";
  } else if (overBlue) {
    currentShapeColor = color(0,0,255);
    currentColor = "blue";
  } else if (overYellow) {
   currentShapeColor = color(255,255,0);
   currentColor = "yellow";
  } else if (overPink) {
    currentShapeColor = color(255,0,255);
    currentColor = "pink";
  } else if (overOrange) {
    currentShapeColor = color(255,128,0);
    currentColor = "orange";
  } else if (overSqaure) {
     xOffset = mouseX-SquareX;
     yOffset = mouseY-SquareY; 
  } else if (overCircle) {
    CircleX = mouseX;
    CircleY = mouseY;
  } else if (overRectangle) {
     xOffset = mouseX-RectangleX;
     yOffset = mouseY-RectangleY;
  } else if (overCircle) {
    CircleX = mouseX;
    CircleY = mouseY;
  } else if (overClear) {
    dialogue.clearButton();
    shapesInDrawingBoard.clear();  
    shapes.clear();
    colors.clear();
  } else if (overHelp) {
    dialogue.helpButton();
  } else if (overRepeat) {
    dialogue.repeatButton();
  } else if (overSubmit) {
    dialogue.SubmitButton();
  } else if (checkonTest()) {
     dialogue.alreadyonTest();
  } else if (whichTest()) {
    dialogue.pressWrongTest();
  }
}


void mouseDragged() {
  if (overSqaure) {
    SquareX = mouseX-xOffset;
    SquareY = mouseY-yOffset;
  } else if (overRectangle) {
    RectangleX = mouseX-xOffset;
    RectangleY = mouseY-yOffset;
  } else if (overCircle) {
    CircleX = mouseX;
    CircleY = mouseY;
  }
}

void mouseReleased() {
  if ((SquareinDrawingBoard(SquareX, SquareY) || RectangleinDrawingBoard(RectangleX, RectangleY) || CircleinDrawingBoard(CircleX, CircleY)) && currentColor == "white") {
    dialogue.whiteShapeOnDrawingBoard();
  }
 if (SquareinDrawingBoard(SquareX, SquareY) && currentColor != "white") {
   square = createShape(RECT, SquareX, SquareY, SquareSize, SquareSize);
   square.setFill(currentShapeColor);
   shapesInDrawingBoard.add(square);
   colors.add(currentColor);
   shapes.add("square");
   SquareX = initialSquareX;
   SquareY = initialSquareY;
 } else {
   SquareX = initialSquareX;
   SquareY = initialSquareY;
 }
  if (RectangleinDrawingBoard(RectangleX, RectangleY) && currentColor != "white") {
   rectangle = createShape(RECT, RectangleX, RectangleY, RectangleW, RectangleH);
   rectangle.setFill(currentShapeColor);
   shapesInDrawingBoard.add(rectangle);
   colors.add(currentColor);
   shapes.add("rectangle");
   RectangleX = initialRectangleX;
   RectangleY = initialRectangleY;
 } else {
   RectangleX = initialRectangleX;
   RectangleY = initialRectangleY;
 }
 if (CircleinDrawingBoard(CircleX, CircleY) && currentColor != "white") {
   circle = createShape(ELLIPSE, CircleX, CircleY, CircleSize, CircleSize);
   circle.setFill(currentShapeColor);
   shapesInDrawingBoard.add(circle);
   colors.add(currentColor);
   shapes.add("circle");
   CircleX = initialCircleX;
   CircleY = initialCircleY;
 
 } else {
   CircleX = initialCircleX;
   CircleY = initialCircleY;
 }
} 

//Detects if the mouse is over a rectangle shape
boolean overRect(int x, int y, int width, int height)  {
  if (mouseX >= x && mouseX <= x+width && 
      mouseY >= y && mouseY <= y+height) {
    return true;
  } else {
    return false;
  }
}

//detects if the mouse if over an eclipse shape
boolean overCircle(int x, int y, int diameter) {
  float disX = x - mouseX;
  float disY = y - mouseY;
  if (sqrt(sq(disX) + sq(disY)) < diameter/2 ) {
    return true;
  } else {
    return false;
  }
}

//Checks if square player dragged is in drawing board 
boolean SquareinDrawingBoard(int x, int y) {
  if (drawingBoardRectX <= x && drawingBoardRectW >= x-25 && drawingBoardRectY <= y && drawingBoardRectL >= y) {
    return true;
  } else {
    return false;
  }
}


//Checks if rectangle player dragged is in drawing board 
boolean RectangleinDrawingBoard(int x, int y) {
  if (drawingBoardRectX <= x && drawingBoardRectW >= x-25 && drawingBoardRectY <= y && drawingBoardRectL >= y+52) {
    return true;
  } else {
    return false;
  }
}


//Checks if circle player dragged is in drawing board 
boolean CircleinDrawingBoard(int x, int y) {
  if (drawingBoardRectX <= x - 75 && drawingBoardRectW >= x - 100 && drawingBoardRectY <= y - 73 && drawingBoardRectL >= y-73) {
   return true; 
  } else {
  return false;
  }
}

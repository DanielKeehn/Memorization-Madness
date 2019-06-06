class Setup {
  
  Setup() {}
  
  void setup() {
    stroke(128,128,128);
    strokeWeight(4);
    PFont font;
    background(0);
  
  //This is the board where you can drags shape
  fill(255);
  rect(drawingBoardRectX, drawingBoardRectY, drawingBoardRectW, drawingBoardRectL);
  
  //Draws the test rectangles on the screen
  fill(fillColorTest1);
  rect(rect1x,recty,rectwidth, rectheight);
   fill(fillColorTest2);
  rect(rect2x,recty,rectwidth,rectheight);
   fill(fillColorTest3);
  rect(rect3x,recty,rectwidth,rectheight);
   fill(fillColorTest4);
  rect(rect4x,recty,rectwidth,rectheight);
   fill(fillColorTest5);
  rect(rect5x,recty,rectwidth,rectheight);
   fill(fillColorTest6);
  rect(rect6x,recty,rectwidth, rectheight);
   fill(fillColorTest7);
  rect(rect7x,recty,rectwidth,rectheight);
   fill(fillColorTest8);
  rect(rect8x,recty,rectwidth,rectheight);
   fill(fillColorTest9);
  rect(rect9x,recty,rectwidth,rectheight);
   fill(fillColorTest10);
  rect(rect10x,recty,rectwidth,rectheight);
  
  //Draws the text that go inside the test rectangles on the screen
  fill(0);
  font = loadFont("Bahnschrift-48.vlw");
  textFont(font);
  textSize(50);
  text("Test 1", rect1x + 15, testTexty - 8); 
  text("Test 2", rect2x + 10, testTexty - 8);
  text("Test 3", rect3x + 10, testTexty - 8);
  text("Test 4", rect4x + 10, testTexty - 8);
  text("Test 5", rect5x + 10, testTexty - 8);
  text("Test 6", rect6x + 10, testTexty - 8); 
  text("Test 7", rect7x + 10, testTexty - 8);
  text("Test 8", rect8x + 10, testTexty - 8);
  text("Test 9", rect9x + 10, testTexty - 8);
  textSize(45);
  text("Test 10", rect10x + 8, testTexty - 10);
  
  //draws the clear button and text
   fill(fillColorClear);
  rect(clearButtonx, clearButtony, clearButtonwidth, clearButtonheight);
  font = loadFont("Bahnschrift-48.vlw");
  textFont(font);
  fill(0);
  textSize(55);
  text("Clear", clearButtonx + 10, clearButtony + 70);
  
  noStroke();
  
  //Draws the colors that change the shapes in the game
  fill(255,0,0);
  rect(colorWidth, colorHeight1, colorSize, colorSize);
  fill(0,255,0);
  rect(colorWidth, colorHeight2, colorSize, colorSize);
  fill(0,0,255);
  rect(colorWidth, colorHeight3, colorSize, colorSize);
  fill(255,255,0);
  rect(colorWidth, colorHeight4, colorSize, colorSize);
  fill(255,0,255);
  rect(colorWidth, colorHeight5, colorSize, colorSize);
  fill(255,128,0);
  rect(colorWidth, colorHeight6, colorSize, colorSize);
  
  //Creates all the shapes in the game with a default white color
  fill(currentShapeColor);
  rect(SquareX, SquareY, SquareSize, SquareSize);
  ellipse(CircleX, CircleY, CircleSize, CircleSize);
  rect(RectangleX,RectangleY,RectangleW,RectangleH);
  
  stroke(128,128,128);
  strokeWeight(4);
  
  //Creates the help button 
  fill(fillColorHelp);
  rect(helpButtonX, helpButtonY, helpButtonSizeW, helpButtonSizeL);
  fill(0);
  textSize(45);
  text("?", helpButtonX + 15, helpButtonY + 38);
  
  //Creates the repeat button 
  fill(fillColorRepeat);
  rect(repeatButtonX, repeatButtonY, repeatButtonSizeW, repeatButtonSizeL);
  fill(0);
  textSize(45);
  text("R", repeatButtonX + 10, repeatButtonY + 38);
  
  //Creates the sumbit button and check mark in it
  fill(fillColorSubmit);
  rect(submitButtonX, submitButtonY, submitButtonSizeW, submitButtonSizeL);
  fill(0);
  textSize(46);
  text("Submit", submitButtonX + 3, submitButtonY + 67);
  
  fill(255);
  font = loadFont("BookmanOldStyle-Bold-48.vlw");
  textFont(font);
  textSize(80);
  text("Memorization Madness", 225, 110);
  strokeWeight(2);
  rect(225, 120, 960, 5);
  }
}

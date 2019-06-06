class Test {
  
  String color1 = "";
  String shape1 = "";
   
  Test() {
  }
  
  void test1() {
     level = 1;
     colorsCompare.clear();
     shapesCompare.clear();
     shapesInDrawingBoard.clear();   
    int randomShape = int(random(3));
    if (randomShape == 0) {
       shape1 = "square";
       shapesCompare.add(shape1);
     } else if (randomShape == 1) {
       shape1 = "circle";
       shapesCompare.add(shape1);
     } else if (randomShape == 2) {
       shape1 = "rectangle";
       shapesCompare.add(shape1);
     }
       
       int randomColor = int(random(6));
       if (randomColor == 0) {
        color1 = "red";
        colorsCompare.add(color1);
      } else if (randomColor == 1) {
        color1 = "green";
        colorsCompare.add(color1);
      } else if (randomColor == 2) {
        color1 = "blue";
        colorsCompare.add(color1);
      } else if (randomColor == 3) {
        color1 = "yellow";
        colorsCompare.add(color1);
      } else if (randomColor == 4) {
        color1 = "pink";
        colorsCompare.add(color1);
      } else if (randomColor == 5) {
        color1 = "orange";
        colorsCompare.add(color1);
     }
     dialogue.test1();
     dialogue.test1Answer();
     ontest1 = true;
}

  void checkTest1Repeat() {
    if (ontest1) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size() && colorsCompare.get(0) == colors.get(0) && shapesCompare.get(0) == shapes.get(0)) {
           dialogue.answerRight();
            for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
            }
            shapesInDrawingBoard.clear();
  
           ontest1 = false;
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }
  
    void test2() {
      level = 2;
      colorsCompare.clear();
      shapesCompare.clear();
      for (int i = 1; i < 3; i++) {
        int randomShape = int(random(2));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 3; i++) {
         int randomColor = int(random(3));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test2();
       dialogue.test2Answer();
       ontest2 = true;
  }
  
  void checkTest2Repeat() {
    if (ontest2) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 3; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest2 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }
  
  void test3() {
     level = 3;
     colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 4; i++) {
        int randomShape = int(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 4; i++) {
         int randomColor = int(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test3();
       dialogue.test3Answer();
       ontest3 = true;
  }
  
  void checkTest3Repeat() {
     if (ontest3) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 4; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest3 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
           livesLeft--;
           dialogue.lostLife();
        }
        }
    }
  }
  
  void test4() {
    level = 4;
    colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 5; i++) {
        int randomShape = int(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 5; i++) {
         int randomColor = int(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test4();
       dialogue.test4Answer();
       ontest4 = true;
  }
  
  void checkTest4Repeat() {
      if (ontest4) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 5; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest4 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }
  
  void test5() {
   level = 5;
   colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 6; i++) {
        int randomShape = int(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 6; i++) {
         int randomColor = int(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test5();
       dialogue.test5Answer();
       ontest5 = true;
  } 
  
  void checkTest5Repeat() {
      if (ontest5) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 6; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest5 = false;
              } else {
               livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
           dialogue.lostLife();
        }
        }
    }
  }
  
  void test6() {
     level = 6;
     colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 7; i++) {
        int randomShape = int(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 7; i++) {
         int randomColor = int(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test6();
       dialogue.test6Answer();
       ontest6 = true;
  }
  
  void checkTest6Repeat() {
     if (ontest6) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 7; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest6 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
         livesLeft--;
         dialogue.lostLife();
        }
        }
    }
  }
  
  void test7() {
    level = 7;
    colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 8; i++) {
        int randomShape = int(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 8; i++) {
         int randomColor = int(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test7();
       dialogue.test7Answer();
       ontest7 = true;  
  }
  
  void checkTest7Repeat() {
     if (ontest7) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 8; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest7 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }
  
  void test8() {
    level = 8;
     colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 9; i++) {
        int randomShape = int(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 9; i++) {
         int randomColor = int(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test8();
       dialogue.test8Answer();
       ontest8 = true;  
  }
  
  void checkTest8Repeat() {
     if (ontest8) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 9; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest8 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }
  
  void test9() {
    level = 9;
     colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 10; i++) {
        int randomShape = int(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 10; i++) {
         int randomColor = int(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test9();
       dialogue.test9Answer();
       ontest9 = true;  
  }
  
  void checkTest9Repeat() {
     if (ontest9) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 10; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest9 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }
  
  void test10() {
    level = 10;
     colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 11; i++) {
        int randomShape = int(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 11; i++) {
         int randomColor = int(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test10();
       dialogue.test10Answer();
       ontest10 = true;  
  }
  
  void checkTest10Repeat() {
     if (ontest10) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 11; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest10 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }

 }

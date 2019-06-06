class Dialogue {
  
  Dialogue() {
    playerName = "Daniel";
    tts = new TTS();
  }
  void intro() {
     tts.speak("Hello " + playerName + ", my name is dab. That stands for drawing assistant buddy. Welcome to memorization madness! This game has ten increasingly harder memorization tests. Practice dragging shapes or press test 1 to begin");
  }
  
  int helpButtonInt = -1;
  void helpButton() {
    if (helpButtonInt == -1) {
      tts.speak("This is the help button. Press it again to learn how to use the drawing interface and play the game");
      helpButtonInt++;
    } else if (helpButtonInt == 0) {
      tts.speak("So " + playerName + ", you want to learn how to play? Well first off, the white area in the middle of the screen is the drawing board. This is where you can put shapes. Click and drag a shape on the left of the drawing board and drag it"
       + "to the drawing board to make a shape. The shape will only stay in place if you drag the shape to the drawing board. To change the color of the shape, simply press on the colored rectangles on the left. You can not put white shapes on the drawing board," 
       + " so make sure to change the color before you start creating. Other than that, press the clear button to clear all shapes on the drawing board, press the repeat button to repeat the things you must memorize one time, or press test 1 to begin."
       + " I will tell you when you can press the other test buttons");
       helpButtonInt++;
    } else if (helpButtonInt == 1) {
      tts.speak("Did you listen to what I said the first time, " + playerName + ". Well I guess not so let me tell you everything again. The white, area in the middle is the drawing board. Drag shapes to the left of the drawing board here. Press the color buttons to the" 
      + " left to change the color of the shapes. Do not add white shapes. The clear button clears all the shapes from the drawing board. The repeat button repeats the shapes and colors you must memorize once, The test one button begins the game");
      helpButtonInt++;
    } else if (helpButtonInt == 2) {
      tts.speak("Really, " + playerName + ", is your memory really that bad. All you do is drag the shapes on the left to the drawing board. Change the colors of the shapes with the colors to the left. Everything else is very obvious. Just figure it out"
      + ", You obviously can not listen to me," + playerName + ",This is the last time I will explain this to you");
      helpButtonInt++;
    } else if (helpButtonInt == 3){
      tts.speak("Leave me alone," + playerName + ", you are trying to annoy me or you are t0o stupid to play this game. I have already told you what to do");
      helpButtonInt++;
    } else if (helpButtonInt == 4) {
      tts.speak("Not listening anymore. I will just watch some you tube videos until you are ready to start");
      helpButtonInt++;
    } else if (helpButtonInt == 5) {
      tts.speak("HAHAHAHAHAHAHAHA, Pew de pie is the funniest you tuber, he reviews me mes very well. Oh hello ," + playerName + ", I am still waiting");
      helpButtonInt++;
    } else if (helpButtonInt == 6) {
      tts.speak("System shutting down, participant is to dumb to continue, unless he stops does something other than press the freaking help button");
    }
  }
  
  boolean clearFirstDialogue = false;
  boolean pressClearButton = false;
  void clearButton() {
     if (finishedTest1Setup == false && clearFirstDialogue == false && shapesInDrawingBoard.size() == 0 && pressClearButton == false) {
         tts.speak("This is the clear button. All the shapes in the drawing board will dissappear, unless they are shapes placed in previous tests");
         clearFirstDialogue = true;
         pressClearButton = true;
       } else {
         if (shapesInDrawingBoard.size() == 0) {
         pressClearButton = true;
         int randomDialogue = int(random(5));
          if (randomDialogue == 0) {
            tts.speak("There is nothing to clear, " + playerName);
          } else if (randomDialogue == 1) {
             tts.speak("Why would you use the clear button with no shapes in the drawing board");     
          } else if (randomDialogue == 2) {
             tts.speak("Error 387, " + playerName + ", no shapes to clear");     
          } else if (randomDialogue == 3) {
             tts.speak(playerName + ", it is impossible to clear things when there is nothing to clear");     
          } else if (randomDialogue == 4) {
             tts.speak("There are zero things to remove");     
          }
        } else {
          pressClearButton = true;
          int randomDialogue = int(random(5));
          if (randomDialogue == 0) {
             tts.speak("Say bye to the shapes, " + playerName);
           } else if (randomDialogue == 1) {
              tts.speak("Clearing Shapes");     
           } else if (randomDialogue == 2) {
              tts.speak("Erase erase erase");     
           } else if (randomDialogue == 3) {
              tts.speak(playerName + ", the shapes will leave as you wish");     
           } else if (randomDialogue == 4) {
              tts.speak("Bye shapes");     
           }
        }
      } 
   }
  
    int repeatButtonInt = 0;
    boolean repeatButtonIntt1 = true;
    boolean repeatButtonIntt2 = true;
    boolean repeatButtonIntt3 = true;
    boolean repeatButtonIntt4 = true;
    boolean repeatButtonIntt5 = true;
    boolean repeatButtonIntt6 = true;
    boolean repeatButtonIntt7 = true;
    boolean repeatButtonIntt8 = true;
    boolean repeatButtonIntt9 = true;
    boolean repeatButtonIntt10 = true;
  void repeatButton() {
    if (finishedTest1Setup == false) {
      if (repeatButtonInt == 0) {
        tts.speak("This is the repeat button. You can use it in game to repeat the shapes and colors you must memorize. It can only be used once though for each test");
        repeatButtonInt++;
      } else if (repeatButtonInt == 1) {
        tts.speak(playerName + ", Like I said before, this is the repeat button. I will repeat what you must memorize for each test once when you press this button");
        repeatButtonInt++;
      } else if (repeatButtonInt == 2) {
        tts.speak(playerName + ", I have already talked about the repeat button twice. It allows you to here what you must memorize a second time for the tests");
        repeatButtonInt++;
      } else if (repeatButtonInt == 3) {
        tts.speak("Come on, I know you know what to do, " + playerName);
        repeatButtonInt++;
      } else if (repeatButtonInt == 4) {
        tts.speak("I will ignore you now, ");
        repeatButtonInt++;
      } else if (repeatButtonInt == 5) {
        tts.speak("I will shut this game down, " + playerName + ", if you press the repeat button again. I am serious and have the power to do this");
        repeatButtonInt++;
      } else if (repeatButtonInt == 6) {
        tts.speak("See you later, maybe you will listen to be next time");
        repeatButtonInt++;
        exit();
      }
    } else {
      if (ontest1 && repeatButtonIntt1) {
        dialogue.test1Answer();
        repeatButtonIntt1 = false;
      } else if (ontest2 && repeatButtonIntt2) {
        dialogue.test2Answer();
        repeatButtonIntt2 = false;
      } else if (ontest3 && repeatButtonIntt3) {
        dialogue.test3Answer();
        repeatButtonIntt3 = false;
      } else if (ontest4 && repeatButtonIntt4) {
        dialogue.test4Answer();
        repeatButtonIntt4 = false;
      } else if (ontest5 && repeatButtonIntt5) {
        dialogue.test5Answer();
        repeatButtonIntt5 = false;
      } else if (ontest6 && repeatButtonIntt6) {
        dialogue.test6Answer();      
        repeatButtonIntt6 = false;
      } else if (ontest7 && repeatButtonIntt7) {
        dialogue.test7Answer();
        repeatButtonIntt7 = false;
      } else if (ontest8 && repeatButtonIntt8) {
        dialogue.test8Answer();
        repeatButtonIntt8 = false;
      } else if (ontest9 && repeatButtonIntt9) {
        dialogue.test9Answer();
        repeatButtonIntt9 = false;
      } else if (ontest10 && repeatButtonIntt10) {
        dialogue.test10Answer();
        repeatButtonIntt10 = false;
      } else {
        int randomDialogue = int(random(5));
        if (randomDialogue == 0) {
           tts.speak("You have already pressed the repeat button");
        } else if (randomDialogue == 1) {
          tts.speak("Nice try, " + playerName + ", you can only press the repeat button once per test");  
        } else if (randomDialogue == 2) {
          tts.speak("Try to remember what I said, you already pressed repeat");  
        } else if (randomDialogue == 3) {
          tts.speak("If you can not remember what I said the first two times, you can not pass the test I guess, " + playerName);  
        } else if (randomDialogue == 4) {
          tts.speak("I wish I could help you, but I can only repeat the answer once");  
        }
    
      }
    }
  }
  
  void test1() {
   int randomDialogue = int(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the first test. This is a warm up. You must memorize one shape and one color.");
   } else if (randomDialogue == 1) {
     tts.speak("Congratulations, you have pressed the first test. I know you can do this one.");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 1, it is very easy. Just put down one colored shape.");
   }
   tts.speak("Remember, you can pass the repeat button, the button with an R, to repeat what you must memorize once for each rounds");
  }
  
  void test1Answer() {
     tts.speak("Just put a," + colorsCompare.get(0) + ". " + shapesCompare.get(0) + ". On the drawing board");
  }
    
  void test2() {
   int randomDialogue = int(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the second test. This is slightly harder than the first test. You must memorize two shapes and two colors.");
   } else if (randomDialogue == 1) {
     tts.speak("Congratulations, you have made it to rouund two, it was easy, was it not.");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 2, it is just slightly harder than the first one.");
   }
  }
  
 void test2Answer() {
   tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) + ", on the drawing canvas");
 }
  
  void test3() {
    int randomDialogue = int(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the third test. You must memorize three shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("Congratulations, you have passed two easy tests. This should not give you too much trouble either");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 3, remember you can press the R button to repeat the answer once per round");
   }
  }
  
  void test3Answer() {
     tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2) + ", in the drawing board");
  }
  
  void test4() {
   int randomDialogue = int(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the fourth test. You must memorize four shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("The steaks are now raised. It is getting harder, you must memorize four things");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 4, try your best, you need to memorize four shape and color combinations");
   }
  }
  
  void test4Answer() {
      tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3) + ",on the drawing board");
  }
  
  void test5() {
   int randomDialogue = int(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the test number five. You must memorize five shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("Great job, " + playerName + ", you are now almost halfway done with this game");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 5, it might get harder now, you need to memorize four shape and color combinations");
   }
  }
  
  void test5Answer() {
    tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3)+ ",  and a, " + colorsCompare.get(4) + ", " + shapesCompare.get(4) + ", on the drawing board");
  }
  
  void test6() {
   int randomDialogue = int(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the sixth test. You must memorize six shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("This is the harder part of the game, you must memorize six things");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 6, try to focus on what I am about to say, you need to memorize six shape and color combinations");
   }
  }
  
  void test6Answer() {
    tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3)+ ",  and a, " 
         + colorsCompare.get(4) + ", " + shapesCompare.get(4) + ",  and a, " + colorsCompare.get(5) + ", " + shapesCompare.get(5) + ", in the drawing board");
  }
  
  void test7() {
   int randomDialogue = int(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the seventh test. You must memorize seven shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("I am impressed about how far you are getting, you must memorize seven things now. That is a lot");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 7, your memory is above average if you got here, you need to memorize seven shape and color combinations");
   }
  }
  
  void test7Answer() {
     tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3)+ ",  and a, " 
         + colorsCompare.get(4) + ", " + shapesCompare.get(4) + ",  and a, " + colorsCompare.get(5) + ", " + shapesCompare.get(5) + ",  and a, " + colorsCompare.get(6) + ", " + shapesCompare.get(6) + ", in the drawing board");
  }
  
  void test8() {
   int randomDialogue = int(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the eighth test. You must memorize eight shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak(playerName + ", you need to memorize eight things now, I know you can do this");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 8, you are getting near the end of the game, you need to memorize eight shape and color combinations");
   }
  }
  
  void test8Answer() {
     tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3)+ ",  and a, " 
         + colorsCompare.get(4) + ", " + shapesCompare.get(4) + ",  and a, " + colorsCompare.get(5) + ", " + shapesCompare.get(5) + ",  and a, " + colorsCompare.get(6) + ", " + shapesCompare.get(6)
          + ",  and a, " + colorsCompare.get(7) + ", " + shapesCompare.get(7) + ", in the drawing board");
  }
  
  void test9() {
   int randomDialogue = int(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the ninth test. You must memorize nine shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("Only two tests left now. It is getting very hard right now, you must memorize nine things");
   } else if (randomDialogue == 2) {
     tts.speak("This is test nine, you have come so far, you need to memorize nine shape and color combinations");
   }
  }
  
  void test9Answer() {
      tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3)+ ",  and a, " 
         + colorsCompare.get(4) + ", " + shapesCompare.get(4) + ",  and a, " + colorsCompare.get(5) + ", " + shapesCompare.get(5) + ",  and a, " + colorsCompare.get(6) + ", " + shapesCompare.get(6)
         + ",  and a, " + colorsCompare.get(7) + ", " + shapesCompare.get(7) + ",  and a, " + colorsCompare.get(8) + ", " + shapesCompare.get(8) + ", on the drawing board");
  }
  
  void test10() {
   int randomDialogue = int(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the tenth test. The final test. You must memorize ten shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("This is the last test in the game. I am very impressed you got this far. You must memorize ten things");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 10, the ultimate test, you need to memorize ten shape and color combinations");
   }
  }
  
  void test10Answer() {
       tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3)+ ",  and a, " 
         + colorsCompare.get(4) + ", " + shapesCompare.get(4) + ",  and a, " + colorsCompare.get(5) + ", " + shapesCompare.get(5) + ",  and a, " + colorsCompare.get(6) + ", " + shapesCompare.get(6)
         + ",  and a, " + colorsCompare.get(7) + ", " + shapesCompare.get(7) + ",  and a, " + colorsCompare.get(8) + ", " + shapesCompare.get(8)
         +  ",  and a, " + colorsCompare.get(9) + ", " + shapesCompare.get(9) + ", on the drawing board");
  }
  
  void youWon() {
    tts.speak("Congratulations " + playerName + ", you have completed all of the tests I gave you. You have one of the best memorizations I know. Either that or you cheated and wrote down all the answers. Have a nice day and play again");
  }
  
  void gameOver() {
    Integer i = new Integer(level);   
    String onLevel = i.toString();
    if (level == 1) {
      tts.speak("You got to level, " + onLevel + ", That is sad, I know you can pass level one");
    } else if (level == 2) {
      tts.speak("You got to level, " + onLevel + ", Really you basically did nothing");
    } else if (level == 3) {
      tts.speak("You got to level, " + onLevel + ", you probably have a very bad memory");
    } else if (level == 4) {
      tts.speak("You got to level, " + onLevel + ", you were just getting to the challenge");
    } else if (level == 5) {
      tts.speak("You got to level, " + onLevel + ", not to shabby but you can do better");
    } else if (level == 6) {
      tts.speak("You got to level, " + onLevel + ", you got a pretty good memory but not good enough to win");
    } else if (level == 7) {
      tts.speak("You got to level, " + onLevel + ", you are getting closer to winning, you might just be able to win");
    } else if (level == 8) {
      tts.speak("You got to level, " + onLevel + ", very impressive, a few more levels will grant you a victory");
    } else if (level == 9) {
      tts.speak("You got to level, " + onLevel + ", I can smell a victory coming soon");
    } else if (level == 10) {
      tts.speak("You got to level, " + onLevel + ", tough luck, you could not have gotten any closer");
    }
    tts.speak("Feel free to play again and get to an even better level or maybe even complete the game");
  }
  
  int whiteShapeNum = 0;
  void whiteShapeOnDrawingBoard() {
    if (whiteShapeNum == 0) {
      tts.speak(playerName + ", white shapes can not be dragged on the drawing board. Please select a color first");
      whiteShapeNum++;
    } else if (whiteShapeNum == 1) {
       tts.speak("Ok " + playerName + ", please listen. Select a color, You can not drag white shapes on the drawing board");
       whiteShapeNum++;
    } else if (whiteShapeNum == 2) {
      tts.speak("This is getting annoying " + playerName + ", change the color before dragging shapes");
       whiteShapeNum++;
    } else if (whiteShapeNum == 3) {
      tts.speak("I will continue to ignore you if you do not listen to me");
      whiteShapeNum++;
    } else if (whiteShapeNum == 4) {
      tts.speak("I am just gonna listen to music until you decide to listen to me");
      whiteShapeNum++;
    } else if (whiteShapeNum == 5) {
      tts.speak("Cause this is thriller. Thriller night. And no one's gonna save you from the beast about to strike. You know it’s thriller, Thriller night");
      whiteShapeNum++;
    } else if (whiteShapeNum == 6) {
      tts.speak("I can show you the world, Shining, shimmering splendid, Tell me, princess, now when did You last let your heart decide? I can open your eyes, Take you wonder by wonder, Over sideways and under, On a magic carpet ride, A whole new world");
      whiteShapeNum++;
    } else if (whiteShapeNum == 7) {
      tts.speak("I'm upset. Fifty thousand on my head, it's disrespect. So offended that I had to double check. I'ma always take the money over sex. That's why they need me out the way What you expect?. Got a lot of blood and it's cold."
        + "They keep tryna get me for my soul. Thankful for the women that I know. Can't go fifty-fifty with no hoe");
      whiteShapeNum++;
    } else if (whiteShapeNum == 8) {
     tts.speak("Back in black. I hit the sack. I've been too long I'm glad to be back. Yes, I'm let loose. From the noose. That's kept me hanging about. I've been looking at the sky. Cause it's gettin' me high. Forget the hearse 'cause I never die"
     + "I got nine lives. Cat's eyes. Abusin' every one of them and running wild");
     whiteShapeNum++;
    } else if (whiteShapeNum == 9) {
      tts.speak("You do not deserve to hear my beatiful singing voice anymore. Shutting down");
      whiteShapeNum++;
    }
  }
  
  boolean clearFirstSubmit = false;
  boolean pressSubmitButton = false;
  void SubmitButton() {
    if (finishedTest1Setup == false) {
       if (finishedTest1Setup == false && clearFirstSubmit == false && shapesInDrawingBoard.size() == 0 && pressSubmitButton == false) {
         tts.speak("This is the submit button. It checks if you have past the test. If you press submit and you do the test incorrectly, you will lose a life");
         clearFirstSubmit = true;
         pressSubmitButton = true;
       } else {
         int randomDialogue = int(random(5));
         if (randomDialogue == 0) {
           tts.speak("Can not submit anything when you are in practice mode");
         } else if (randomDialogue == 1) {
           tts.speak(playerName + ", please begin a test before pressing the submit button");
         } else if (randomDialogue == 2) {
           tts.speak("This button is useless if you are not on a test");
         } else if (randomDialogue == 3) {
           tts.speak("I am waiting for you to press the test button, " + playerName + ", before this button will do something");
         } else if (randomDialogue == 4) {
           tts.speak("Congratulations, you did absolutely nothing");
         }
       }
    } else {
       if (ontest1 == false && ontest2 == false && ontest3 == false && ontest4 == false && ontest5 == false && ontest6 == false && ontest7 == false && ontest8 == false && ontest9 == false && ontest10 == false) {
      int randomDialogue = int(random(5));
         if (randomDialogue == 0) {
           tts.speak("Can not submit anything when you are in between tests");
         } else if (randomDialogue == 1) {
           tts.speak(playerName + ", please press the next test before pressing the submit button");
         } else if (randomDialogue == 2) {
           tts.speak("This button is useless if you are not on a test");
         } else if (randomDialogue == 3) {
           tts.speak("I am waiting for you to press the test button, " + playerName + ", before this button will do something");
         } else if (randomDialogue == 4) {
           tts.speak("Congratulations, you did absolutely nothing");
         }
      }
     }
  }
  
  void lostLife() {
    int randomDialogue = int(random(5));
         if (randomDialogue == 0) {
           tts.speak("Somebody just answered the test wrong");
         } else if (randomDialogue == 1) {
           tts.speak(playerName + ", you just lost a life, sorry");
         } else if (randomDialogue == 2) {
           tts.speak("Rest in peace one of your lifes, " + playerName);
         } else if (randomDialogue == 3) {
           tts.speak("You just lost a life , " + playerName + ", do not run out of lives");
         } else if (randomDialogue == 4) {
           tts.speak("Congratulations, you just lost a life");
         }
      Integer i = new Integer(livesLeft);   
      String lives = i.toString();
      tts.speak("You have," + lives + ", lives left");
  
    }
    
    void answerRight() {
      int randomDialogue = int(random(5));
       if (randomDialogue == 0) {
          tts.speak("Nice job, " + playerName + ", you may move on to the next test");
        } else if (randomDialogue == 1) {
          tts.speak(playerName + ", that is correct");
        } else if (randomDialogue == 2) {
          tts.speak("Someone is moving on to the next test, " + playerName);
        } else if (randomDialogue == 3) {
          tts.speak("Congratulations , " + playerName + ", press the next test to begin");
        } else if (randomDialogue == 4) {
          tts.speak("Congratulations, you just passed this test");
        }
    }
    
    void pressWrongTest() {
      int randomDialogue = int(random(5));
       if (randomDialogue == 0) {
          tts.speak(playerName + ", you pressed the wrong test number.");
        } else if (randomDialogue == 1) {
          tts.speak("That is not the right test number, " + playerName);
        } else if (randomDialogue == 2) {
          tts.speak("Please press the right test number");
        } else if (randomDialogue == 3) {
          tts.speak("Congratulations , " + playerName + ", you pressed the wrong test number");
        } else if (randomDialogue == 4) {
          tts.speak("That is not the correct test number");
        }
        Integer i = new Integer(level + 1);   
        String nextLevel = i.toString();
        tts.speak("Go to test number, " + nextLevel);
    }
    
    void alreadyonTest() {
       int randomDialogue = int(random(5));
       if (randomDialogue == 0) {
          tts.speak(playerName + ", you can change test numbers because you are already on a test");
        } else if (randomDialogue == 1) {
          tts.speak("Already on a test, " + playerName);
        } else if (randomDialogue == 2) {
          tts.speak("Please do not press the test buttons until you finish this test");
        } else if (randomDialogue == 3) {
          tts.speak(playerName + ", you need to beat this test first");
        } else if (randomDialogue == 4) {
          tts.speak("you can not go to that test now");
        }
    }     
}

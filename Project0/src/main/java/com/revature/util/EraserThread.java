package com.revature.util;

import org.apache.log4j.Logger;

class EraserThread implements Runnable 
{
   private boolean stop;
   static final Logger logger = Logger.getLogger(EraserThread.class);
 
   /**
    *@param The prompt displayed to the user
    */
   public EraserThread(String prompt) {
       System.out.print(prompt);
   }

   /**
    * Begin masking...display asterisks (*)
    */
   public void run () {
      stop = true;
      while (stop) {
         System.out.print("\010*");
	 try {
	    Thread.currentThread().sleep(1);
         } catch(InterruptedException ie) {
            ie.printStackTrace();
         }
      }
   }

   /**
    * Instruct the thread to stop masking
    */
   public void stopMasking() {
      this.stop = false;
   }
}
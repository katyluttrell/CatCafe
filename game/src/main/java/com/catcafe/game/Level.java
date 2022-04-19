package com.catcafe.game;

public abstract class Level implements Runnable{
    //https://stackoverflow.com/questions/3489543/how-to-call-a-method-with-a-separate-thread-in-java
        protected Double moneyGoal;
        protected Invoker invoker;
        protected GameFlow gameFlow;
        protected PlayableCharacter playableCharacter;
        protected Model model;
        protected GamePlay_Controller gameView;
        protected InGameInteractiveUser user;
        public Level(InGameInteractiveUser user, PlayableCharacter playableCharacter, GamePlay_Controller gameView){
            invoker = user.getInvoker();
            model = Model.getInstance();
            this.playableCharacter = playableCharacter;
            this.gameView = gameView;
            this.user = user;
    }
    public void run(){
        gameFlow.startGame();
        double endMoney = gameFlow.getEndMoney();
        if(endMoney >= moneyGoal){
            System.out.println("You Won!!!");
        }
        else{
            System.out.println("You Lost :(");
        }

    }
}
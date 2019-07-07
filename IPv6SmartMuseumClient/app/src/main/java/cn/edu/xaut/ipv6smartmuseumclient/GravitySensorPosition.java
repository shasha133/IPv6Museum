package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by jason on 16-12-2.
 * 惯性传感器获取位置数据的类，它是一个子线程
 * 未来优化方向：依旧是线程的暂停和恢复的处理
 */

public class GravitySensorPosition extends Thread {

    private static int LastStep = 0;
    private static double StandardDirection = 170.0;
    private static boolean isStandardDirectionSet = false;
    private static double PositionX = MapData.grid_width * 1.5;
    private static double PositionY = MapData.grid_height * 1.5;
    private static double StepLength = 0.7;

    private static int CurrentStep = 0;
    private static double CurrentDirection = 0.0;
    private Intent stepService;
    private Intent directionService;
    private Context context;

    public boolean isRunning = false;

    public GravitySensorPosition(Context context) {
        this.context = context;
        stepService = new Intent(context, StepService.class);
        directionService = new Intent(context, DirectionService.class);
    }

    //设置初始方向的方法，有误无法使用！！！
    //初始方向应该用请求获取，或者写在应用里
    public static void setStandardDirection(Context context) {
        isStandardDirectionSet = false;
        Intent temp = new Intent(context, DirectionService.class);
        if (!DirectionService.FLAG) {
            context.startService(temp);
        }
        writeStandardDirection();
        if (DirectionService.FLAG) {
            context.stopService(temp);
        }
        isStandardDirectionSet = true;
    }

    //同上
    private static void writeStandardDirection() {
        double directions = 0;
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            directions += DirectionFunc.CURRENT_DEGREE;
        }
        StandardDirection = directions / 3;
    }

    @Override
    public void run() {
//        while (!isStandardDirectionSet) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        isRunning = true;
        context.startService(stepService);
        context.startService(directionService);
        writeStandardDirection();
        while (isRunning) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                this.interrupt();
                e.printStackTrace();
            }
            if (DirectionService.FLAG && StepService.FLAG) {
                CurrentStep = StepFunc.CURRENT_SETP;
                CurrentDirection = DirectionFunc.CURRENT_DEGREE;
                setPosition();
                Position.setPositionByCoordinate(PositionX, PositionY);
            }
        }
        //Position.resetPosition();
    }

    @Override
    public void interrupt() {
        super.interrupt();
        context.stopService(stepService);
        context.stopService(directionService);
    }

    //把角度直换成弧度值的方法
    private static double getAngle() {
        double angleRadians;
        double angle = CurrentDirection - StandardDirection;
        angleRadians = angle * Math.PI / 180.0;
        return angleRadians;
    }

    //更改位置的方法，用前进方向和移动步数来算，靠三角函数...
    private static void setPosition() {
        int Steps = CurrentStep - LastStep;
        LastStep = CurrentStep;
        setPositionX(Steps);
        setPositionY(Steps);
    }

    private static void setPositionX(int Steps) {
        PositionX = (float) (PositionX + Steps * StepLength * Math.sin(getAngle()));
    }

    private static void setPositionY(int Steps) {
        PositionY = (float) (PositionY + Steps * StepLength * Math.cos(getAngle()));
    }
}

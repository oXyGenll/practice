package com.panteleev;

public class Robot {

    private int x;
    private int y;
    private Direction dir;

    Robot(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    private Direction getDirection() {
        System.out.println(dir);
        return dir;
    }

    private int getX() {
        return x;
    }

    private int getY() {
        return y;
    }

    private void turnLeft() {
        if (dir == Direction.UP) {
            dir = Direction.LEFT;
        } else if (dir == Direction.DOWN) {
            dir = Direction.RIGHT;
        } else if (dir == Direction.LEFT) {
            dir = Direction.DOWN;
        } else if (dir == Direction.RIGHT) {
            dir = Direction.UP;
        }
        System.out.println("turnLeft");
    }

    private void turnRight() {
        if (dir == Direction.UP) {
            dir = Direction.RIGHT;
        } else if (dir == Direction.DOWN) {
            dir = Direction.LEFT;
        } else if (dir == Direction.LEFT) {
            dir = Direction.UP;
        } else if (dir == Direction.RIGHT) {
            dir = Direction.DOWN;
        }
        System.out.println("turnRight");
    }

    private void stepForward() {
        if (dir == Direction.UP) {
            y++;
        }
        if (dir == Direction.DOWN) {
            y--;
        }
        if (dir == Direction.LEFT) {
            x--;
        }
        if (dir == Direction.RIGHT) {
            x++;
        }
        System.out.println("stepForward");
    }

    private static void moveRobotFromUpDirection(Robot robot, int toX, int toY) {
        if (((robot.getY() - toY) != 0) || ((robot.getX() - toX) != 0)) {
            if (robot.getY() < toY) {
                while (toY > robot.getY()) { // Move UP
                    robot.stepForward();
                }
                if (robot.getX() > toX) {
                    robot.turnLeft();
                    while (toX < robot.getX()) {
                        robot.stepForward();
                    }
                } else {
                    robot.turnRight();
                    while (robot.getX() < toX) {
                        robot.stepForward();
                    }
                }
            } // Move DOWN
            else {
                robot.turnLeft();
                robot.turnLeft();
                while (toY < robot.getY()) {
                    robot.stepForward();
                }
                if (robot.getX() > toX) {
                    robot.turnRight();
                    while (toX < robot.getX()) {
                        robot.stepForward();
                    }
                } else {
                    robot.turnLeft();
                    while (robot.getX() < toX) {
                        robot.stepForward();
                    }
                }
            }
        }
    }

    private static void moveRobotFromUpDownDirection(Robot robot, int toX, int toY) {
        if (((robot.getY() - toY) != 0 || (robot.getX() - toX) != 0)) {
            if (robot.getY() > toY) { // Move DOWN
                while (robot.getY() > toY) {
                    robot.stepForward();
                }
                if (robot.getX() > toX) {
                    robot.turnRight();
                    while (robot.getX() > toX) {
                        robot.stepForward();
                    }
                } else {
                    robot.turnLeft();
                    while (toX > robot.getX()) {
                        robot.stepForward();
                    }
                }
            } else {// Move UP
                robot.turnRight();
                robot.turnRight();
                while (toY > robot.getY()) {
                    robot.stepForward();
                }
                if (robot.getX() > toX) {
                    robot.turnLeft();
                    while (robot.getX() > toX) {
                        robot.stepForward();
                    }
                } else {
                    robot.turnRight();
                    while (toX > robot.getX()) {
                        robot.stepForward();
                    }
                }
            }
        }
    }

    private static void moveRobotFromUpLeftDirection(Robot robot, int toX, int toY) {
        if (((robot.getY() - toY) != 0) || ((robot.getX() - toX) != 0)) {
            if (robot.getX() < toX) { // Move RIGHT
                robot.turnLeft();
                robot.turnLeft();
                while (toX > robot.getX()) {
                    robot.stepForward();
                }
                if (robot.getY() > toY) {
                    robot.turnRight();
                    while (robot.getY() > toY) {
                        robot.stepForward();
                    }
                } else {
                    robot.turnLeft();
                    while (toY > robot.getY()) {
                        robot.stepForward();
                    }
                }
            } else { // Move LEFT
                while (robot.getX() > toX) {
                    robot.stepForward();
                }
                if (robot.getY() > toY) {
                    robot.turnLeft();
                    while (toY < robot.getY()) {
                        robot.stepForward();
                    }
                } else {
                    while (robot.getY() < toY) {
                        robot.stepForward();
                    }
                }
            }
        }
    }

    private static void moveRobotFromUpRightDirection(Robot robot, int toX, int toY) {
        if (((robot.getY() - toY) != 0) || ((robot.getX() - toX) != 0)) {
            if (robot.getX() < toX) { // Move RIGHT
                while (robot.getX() < toX) {
                    robot.stepForward();
                }
                if (robot.getY() < toY) {
                    robot.turnLeft();
                    while (toY > robot.getY()) {
                        robot.stepForward();
                    }
                } else {
                    robot.turnRight();
                    while (robot.getY() > toY) {
                        robot.stepForward();
                    }
                }
            } else { // Move LEFT
                robot.turnRight();
                robot.turnRight();
                while (toX < robot.getX()) {
                    robot.stepForward();
                }
                if (robot.getY() > toY) {
                    robot.turnLeft();
                    while (toY < robot.getY()) {
                        robot.stepForward();
                    }
                } else {
                    robot.turnRight();
                    while (robot.getY() < toY) {
                        robot.stepForward();
                    }
                }
            }
        }
    }

    static void moveRobot(Robot robot, int toX, int toY) {
        switch (robot.getDirection()) {
            case UP:
                moveRobotFromUpDirection(robot, toX, toY);
                break;
            case DOWN:
                moveRobotFromUpDownDirection(robot, toX, toY);
                break;
            case LEFT:
                moveRobotFromUpLeftDirection(robot, toX, toY);
                break;
            case RIGHT:
                moveRobotFromUpRightDirection(robot, toX, toY);
                break;
            default:
                break;
        }
    }
}

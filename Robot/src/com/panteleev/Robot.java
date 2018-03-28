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

    static void moveRobot(Robot robot, int toX, int toY) {

        switch (robot.getDirection()) {
            case UP:
                if (((robot.getY() - toY) != 0) || ((robot.getX() - toX) != 0)) {
                    if ((robot.getY() - Math.abs(toY)) < 0) {
                        while ((Math.abs(toY) - robot.getY()) != 0) { // Move UP
                            robot.stepForward();
                        }
                    } // Move DOWN
                    else {
                        robot.turnLeft();
                        robot.turnLeft();
                        while ((Math.abs(toY) - robot.getY()) != 0) {
                            robot.stepForward();
                        }
                        break;
                    }
                    if ((robot.getX() - toX) < 0) {
                        while ((toX - robot.getX()) != 0) {
                            robot.stepForward();
                        }
                    } else {
                        robot.turnLeft();
                        while ((robot.getX() - toX) != 0) {
                            robot.stepForward();
                        }
                    }
                    break;
                } else {
                    break;
                }

            case DOWN:
                if (((robot.getY() - toY) != 0 || (robot.getX() - toX) != 0)) {
                    if ((robot.getY() - toY) > 0) { // Move down
                        while ((robot.getY() - toY) != 0) {
                            robot.stepForward();
                        }
                    } else {
                        robot.turnRight();
                        robot.turnRight();
                        while ((toY - robot.getY()) != 0) { // Move UP
                            robot.stepForward();
                        }
                    }
                    if ((robot.getX() - toX) > 0) {
                        robot.turnRight();
                        while ((robot.getX() - toX) != 0) {
                            robot.stepForward();
                        }
                    } else {
                        while ((toX - robot.getX()) != 0) {
                            robot.stepForward();
                        }
                    }
                    break;
                } else {
                    break;
                }

            case LEFT:
                if (((robot.getY() - toY) != 0) || ((robot.getX() - toX) != 0)) {
                    if (robot.getX() < toX) {
                        robot.turnRight();
                        robot.turnRight();
                        while ((toX - Math.abs(robot.getX())) != 0) robot.stepForward();
                    } else { // Move LEFT
                        while (robot.getX() > toX) {
                            robot.stepForward();
                        }
                    }
                    if (robot.getY() > toY) {
                        robot.turnLeft();
                        while (toY < robot.getY()) {
                            robot.stepForward();
                        }
                    } else {
                        while (robot.getY() < toY) {
                            System.out.println("123");
                            robot.stepForward();
                        }
                    }
                    break;
                } else {
                    break;
                }

            case RIGHT:
                if (((robot.getY() - toY) != 0) || ((robot.getX() - toX) != 0)) {
                    if ((robot.getX() - toX) > 0) { // Move RIGHT
                        robot.turnRight();
                        robot.turnRight();
                        while ((robot.getX() - toX) != 0) {
                            robot.stepForward();
                        }
                    } else {
                        while ((toX - robot.getX()) != 0) {
                            robot.stepForward();
                        }
                    }
                    if ((robot.getY() - toY) <= 0) {
                        while ((toY - robot.getY()) != 0) {
                            robot.stepForward();
                        }
                    } else {
                        robot.turnLeft();
                        while ((robot.getY() - toY) != 0) {
                            robot.stepForward();
                        }
                    }
                    break;
                } else {
                    break;
                }

            default:
                break;
        }
    }
}

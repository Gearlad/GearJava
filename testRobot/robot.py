print("I am a robot")
try:
    import wpilib
except:
    from pyfrc import wpilib
    
print("I am still a robot, mate.");

class myRobot(wpilib.SimpleRobot):
    def __init__(self):
        super().__init__()
def run():
    robot=myRobot()
    robot.StartCompetition()
    return robot

if __name__=='__main__':
    wpilib.run()
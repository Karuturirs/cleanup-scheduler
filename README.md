# cleanup-scheduler
scheduler task that cleans all the file in my local folder  

Problem:

The aim is to make a general purpose scheduler(like crond for linux), preferably in Java. This scheduler basically takes in two parameters:

1. The time at which the scheduler starts the execution of the task.
2. Some representation of action that the scheduler is supposed to execute.

As an example, this scheduler can be scheduled to send reminder push notification to a user’s mobile number. Another action might be completing a scheduled recharge(like recharging with a 15 days validity 3g recharge plan). Think of it in terms of a library that has a very well defined interface to take in the timestamp of trigger and the action to execute. You are required to design this interface and the representation of timestamp and the action suitable to do this as well as implement it. Make your own assumptions.

arguments for the solution:

The main class is MyScheduler.java

1) Arguments: The two arguments that we pass as input are initialized in the code.
                       I commented the different approach to pass arguments( for timestamp  format yyyy-MM-dd HH:mm:ss).
                       The second argument can be passed with 1 or 2 or any number. If other than 2 is passed DummyTask takes place,                          else CleanUp task executes at scheduled time.
2) The action task: It cleans all the files that gets downloaded every day into {project path}/C/Downloads folder.
                    where the files present in {project path}/C/Downloads/Movies are copied to other folders {project path}/D/Movies                      and then cleaned.(As I Download torrent movies frequently in that folder. I do n't want to loose them.)


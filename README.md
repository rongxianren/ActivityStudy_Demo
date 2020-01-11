##### Activity启动模式完全理解学习
* 1、SingleTask 启动模式的特性
    * (1) 如果启动指定 singleTask 启动模式的 Activity，则当某后台任务中存在该 Activity 的实例时，整个任务都会转移到前台。


* 2、taskAffinity 的作用

    * (1) 默认情况下，新Activity会启动到调用 startActivity()<font color =red>的Activity任务中。
      它将推入与调用方相同的返回栈。</font>

    * (2) “关联”指示 Activity 优先属于哪个任务。默认情况下，同一应用中的所有 Activity 彼此关联。
      因此，默认情况下，同一应用中的所有 Activity 优先位于相同任务中。 不过，您可以修改 Activity 的默认关联。
      在不同应用中定义的 Activity 可以共享关联，或者可为在同一应用中定义的 Activity 分配不同的任务关联。

    * (3) 在两种情况下，关联会起作用： <font color="red">其他情况下不起作用</font>
        * 1> 启动 Activity 的 Intent 包含 FLAG_ACTIVITY_NEW_TASK 标志。 SingleTask也会起作用。

        * 2> Activity 将其 allowTaskReparenting 属性设置为 "true"。
            * 在这种情况下，Activity 可以从其启动的任务移动到与其具有关联的任务（如果该任务出现在前台）即Activitya栈转移的效果。

* 3、查看当前任务栈的结构命令
    * adb shell dumpsys activity

* 4、在启动模式为Standard下，单独使用TaskAffinity属性是无效的

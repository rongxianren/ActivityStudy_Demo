##### Activity启动模式完全理解学习

* 1、SingleTask 启动模式的特性
    * (1) 如果启动指定singleTask启动模式的 Activity，则当某后台任务中存在该 Activity 的实例时，<font color="red">整个任务</font>都会转移到前台。
    * (2) SingleTask 默认具有CleanTop特性

* 2、SingleInstance 启动模式是SingleTask的加强版，任务栈中只允许有一个实例，不允许其他Activity实例共存。
    * (1) A(应用入口Act)启动B(SingleInstance taskAffinity 跟默认的不一致),home回到launcher,然后再次点击应用icon，此时显示的是A。
    因为icon入口肯定是启动应用默认的任务栈，此时栈里面只有A,B在另外一个栈里面。要想回到B，切到任务后台点击B对应的任务。
    * (2) 情况跟(1)一样，不同的是B的taskAffinity跟默认的一样，这种情况下，home键回到launcher,点击icon看到的也是A。
    但是此时已经无法回到B了，因为后台只有一个任务存在。
    * (3) 情况跟(2)一样，home回到launcher,然后切到后台任务列表，点击B对应的任务，进入B页面，再点击back按钮，此时回到的launcher页面。

* 3、SingleTop Standard 过于简单不做描述

* 4、taskAffinity 的作用

    * (1) 默认情况下，新Activity会启动到调用 startActivity()<font color =red>的Activity任务中。
      它将推入与调用方相同的返回栈。</font>

    * (2) “关联”指示 Activity 优先属于哪个任务。默认情况下，同一应用中的所有 Activity 彼此关联。
      因此，默认情况下，同一应用中的所有 Activity 优先位于相同任务中。 不过，您可以修改 Activity 的默认关联。
      在不同应用中定义的 Activity 可以共享关联，或者可为在同一应用中定义的 Activity 分配不同的任务关联。

    * (3) 在两种情况下，关联会起作用： <font color="red">其他情况下不起作用</font>
        * 1> 启动 Activity 的 Intent 包含 FLAG_ACTIVITY_NEW_TASK 标志。 SingleTask也会起作用。

        * 2> Activity 将其 allowTaskReparenting 属性设置为 "true"。
            * 在这种情况下，Activity 可以从其启动的任务移动到与其具有关联的任务（如果该任务出现在前台）即Activity栈转移的效果。

* 5、查看当前任务栈的结构命令
    * adb shell dumpsys activity

* 6、在启动模式为Standard下，单独使用TaskAffinity属性是无效的

# Tasking

## Locker
- Given S号Locker有可用容量，When存S号包，Then存包成功，返回S号的票据
- Given S号locker无可用容量，When存S号包，Then存包失败，提示储物柜已满
- Given S号locker，有效的S号票据，When取包，Then取包成功
- Given S号locker，伪造的S号票据，When取包，Then取包失败，提示非法票据
- Given S号locker，重复的S号票据，When取包，Then取包失败，提示非法票据

- Given S号Locker，M号的票据，When取包，Then取包失败，提示票据型号错误
- Given S号Locker，L号的票据，When取包，Then取包失败，提示票据型号错误

## Primary Locker Robot
- Given PrimaryLockerRobot配置列表中除了M号Locker还包含S号和L号Locker，When配置PrimaryLockerRobot，Then 配置失败，提示配置错误
- Given PrimaryLockerRobot配置列表为空，When配置PrimaryLockerRobot，Then 配置失败，提示配置错误
- Given PrimaryLockerRobot管理2个M号的Locker且都有可用容量，M号包，When PrimaryLockerRobot存包，Then包成功存入第1个Locker，返回M号的票据
- Given PrimaryLockerRobot管理2个M号的Locker，locker1已满，locker2有可用容量，M号包，When PrimaryLockerRobot存包，Then包成功存入第2个Locker，返回M号的票据
- Given PrimaryLockerRobot管理2个M号的Locker且都已满，M号包，When PrimaryLockerRobot存包，Then存包失败，提示储物柜已满
- Given 一张有效的M号票据，When取包，Then取包成功
- Given 一张伪造的M号票据，When取包，Then取包失败，提示非法票据
- Given 一张S号票据，When取包，Then取包失败，提示票据型号错误
- Given 一张L号票据，When取包，Then取包失败，提示票据型号错误

## Super Locker Robot
- Given SuperLockerRobot配置列表中包含S号和M号Locker，When配置SuperLockerRobot，Then 配置失败，提示配置错误
- Given SuperLockerRobot配置列表为空，When配置SuperLockerRobot，Then 配置失败，提示配置错误
- Given SuperLockerRobot管理2个L号的Locker且都有可用容量，locker1的空置率最大，L号包，When SuperLockerRobot存包，Then包成功存入第1个Locker，返回L号的票据
- Given SuperLockerRobot管理2个L号的Locker且都有可用容量，locker2的空置率最大，L号包，When SuperLockerRobot存包，Then包成功存入第2个Locker，返回L号的票据
- Given SuperLockerRobot管理2个L号的Locker且都已满，L号包，When SuperLockerRobot存包，Then存包失败，提示储物柜已满
- Given 一张有效的L号票据，When取包，Then取包成功
- Given 一张伪造的L号票据，When取包，Then取包失败，提示非法票据
- Given 一张S号票据，When取包，Then取包失败，提示票据型号错误
- Given 一张M号票据，When取包，Then取包失败，提示票据型号错误

## Locker Robot Manager
- Given manager配置列表中S号Locker已被配置给其他使用，When配置LockerRobotManager，Then配置失败，提示配置错误
- Given manager配置列表中PrimaryLockerRobot管理着其他robot管理的M号Locker，When配置LockerRobotManager，Then配置失败，提示配置错误
- Given manager配置列表中SuperLockerRobot管理着其他robot管理的L号Locker，When配置LockerRobotManager，Then配置失败，提示配置错误
- Given manager管理的S号Locker有可用容量，S号包，When存包，Then存包成功，返回S号票据
- Given manager管理的S号Locker已存满，S号包，When存包，Then存包失败，提示储物柜已满
- Given manager管理的PrimaryLockerRobot有可用容量，M号包，When存包，Then存包成功，返回M号票据
- Given manager管理的PrimaryLockerRobot已存满，M号包，When存包，Then存包失败，提示储物柜已满
- Given manager管理的SuperLockerRobot有可用容量，L号包，When存包，Then存包成功，返回L号票据
- Given manager管理的SuperLockerRobot已存满，L号包，When存包，Then存包失败，提示储物柜已满
- Given 一张有效票据，When取包，Then取包成功
- Given 一张无效票据，When取包，Then取包失败，提示非法票据
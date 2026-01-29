
***************************
APPLICATION FAILED TO START
***************************

Description:

The dependencies of some of the beans in the application context form a cycle:

```
orderController defined in file [/Users/dominikwies/projects/distributed-applications-25-26/target/classes/com/example/dist_app/order/controller/OrderController.class]
┌─────┐
|  orderService defined in file [/Users/dominikwies/projects/distributed-applications-25-26/target/classes/com/example/dist_app/order/service/OrderService.class]
↑     ↓
|  userService defined in file [/Users/dominikwies/projects/distributed-applications-25-26/target/classes/com/example/dist_app/user/service/UserService.class]
└─────┘
```

Action:

Relying upon circular references is discouraged and they are prohibited by default. Update your application to remove the dependency cycle between beans. As a last resort, it may be possible to break the cycle automatically by setting spring.main.allow-circular-references to true.
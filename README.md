# Deadwood

Compile syntax: javac Deadwood.java

Run syntax: java Deadwood x
    -x is the number of players, 2-8 inclusive

**Legal operations during gameplay**

```who```            prints current player

```where```          prints location of current player

```role```           prints role of current player

```room```           prints room of current player and players in the room

```card```           prints the card that is in the players room, along with the roles, rank, and players on those roles

```move-{room}```    moves the current player to room specified by replacing room name with {room}

```work-{role}```    assigns player to the specified role by replacing role name with {role}

```act```            when player is assigned to a role, act sees if the player is successful in acting

```rehearse```       when player is assigned to a role, rehearse adds a practice chip to the player

```upgrade-{type}``` when player is in casting office, player can upgrade their role, specifing payment type by replacing type with $ for dollars and c for credits, will then ask for specific rank

Note: any other input will print out the possible commands

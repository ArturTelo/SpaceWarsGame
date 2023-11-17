## LDTS_T09G04 - SPACE WARS

In this next-gen 2D game, you will be able to play a reimagined space invaders game, you will be able to play solo or local co-op, when playing local co-op both players will share the same screen and keyboard! There will be a lot of different enemies with different characteristics and therefore different difficulty.

This project was developed by *Artur Telo* (*up202104487@fe.up.pt*), *Margarida Fonseca* (*up202207742@fe.up.pt*) and *Nuno França* (*up2018075530@fe.up.pt*) for LDTS 2023/2024.

### IMPLEMENTED FEATURES

> This section should contain a list of implemented features and their descriptions. In the end of the section, include two or three screenshots that illustrate the most important features.

### PLANNED FEATURES

1. **Player Spaceship:**
   - A controllable spaceship at the bottom of the screen that can move horizontally to evade enemy attacks.
  
2. **Enemy Invaders:**
   - Rows of alien invaders that move horizontally and descend towards the player. They fire projectiles at the player's spaceship.

3. **Player Shooting:**
   - The player can shoot projectiles towards the enemy invaders to destroy them.

4. **Enemy Movement:**
   - The enemy invaders move left and right in a coordinated pattern. As they reach the screen edges, they descend one row.

5. **Collision Detection:**
   - Check for collisions between player shots and enemy invaders. If a collision occurs, the corresponding enemy invader is destroyed.

6. **Score System:**
   - Keep track of the player's score, which increases each time an enemy invader is successfully destroyed.

7. **Infinite Level:**
   - Implement an infinite level and as the player progresses and as the time goes by, the speed, health and aggression of the enemy invaders increases and more enemies keep appearing.

8. **Game Over:**
   - Implement a game-over condition. The game ends when the player's spaceship is hit by an enemy projectile and loses all its lives or when the enemy invaders reach the bottom of the screen.

9. **Sound Effects:**
   - Add sound effects for actions such as shooting, enemy destruction, and game over to enhance the gaming experience.

10. **Graphics and Animation:**
    - Use graphics to represent the player's spaceship, enemy invaders, and projectiles. Implement animations for movements and explosions.

11. **Responsive Controls:**
    - Ensure smooth and responsive controls for the player's spaceship, allowing easy navigation and shooting.

12. **Power-ups:**
    - Include 4 power-ups that provide temporary benefits to the player, such as increased damage on the player shots, invincibility for 20 seconds, double the player speed and double the player shots speed.

13. **High Score Tracking:**
    - Keep track of the player's highest score across multiple game sessions.

14. **Pause/Resume Functionality:**
    - Allow the player to pause the game and resume from the same state.

15. **Game Instructions:**
    - Provide clear instructions or a tutorial on how to play the game.

16. **Game Menu:**
    - Create a visually appealing game window with a clear display of the player's score, remaining lives, and other relevant information.

These features collectively contribute to an engaging and enjoyable Space Invasors gaming experience.

### DESIGN

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:

- **Problem in Context.** The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to [link to the relevant lines of code](https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) in the appropriate version.
- **The Pattern.** Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation.** Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). When doing this, always point to the latest version of the code.
- **Consequences.** Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

**Example of one of such subsections**:

------

#### THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

**Problem in Context**

There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

**The Pattern**

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

These classes can be found in the following files:

- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

#### KNOWN CODE SMELLS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

- Artur Telo:
- Margarida Fonseca :
- Nuno França: 
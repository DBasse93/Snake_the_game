# Snake the Game — Project Development Guide

## Quick Reference

| Item | Value |
|------|-------|
| **Project** | Snake_the_game |
| **Language** | Java 21 |
| **UI Framework** | JavaFX 21 |
| **Architecture** | MVC |
| **Build** | `mvn clean install` |
| **Test** | `mvn test` |
| **Full verify** | `mvn clean verify` (runs CheckStyle + PMD + SpotBugs) |
| **Main Branch** | main |

## Architecture

Pattern: **MVC**

```
de.snake.game/
├── model/        — game state (Snake, Apple, GameBoard, Position, Direction)
├── view/         — JavaFX rendering (GameRenderer, scenes)
├── controller/   — input handling, game loop (GameLoop, InputHandler)
└── Main.java     — JavaFX Application entry point
```

Source root: `src/main/java`
Test root: `src/test/java`
Resources: `src/main/resources` (log4j2.xml)

## Critical Rules — Must Always Follow

1. **No `System.out.println()` or `e.printStackTrace()`** — use Log4J 2:
   ```java
   private static final Logger logger = LogManager.getLogger(MyClass.class);
   logger.info("message");
   logger.error("error", e);
   ```

2. **Google Java Style** — all code must pass `mvn checkstyle:check` (google_checks.xml)

3. **No PMD violations** — ruleset: `pmd-custom-ruleset.xml`

4. **No SpotBugs warnings** — run `mvn spotbugs:check`

5. **Every test must have assertions** — never leave a test body empty, never skip assertions

6. **Mockito required in tests** — at least one `@Mock` / `Mockito.when()` usage per test class where dependencies exist

7. **Human-in-the-Loop** — every AI-generated code suggestion must be reviewed and understood before commit. Never ship code you cannot explain.

8. **Git commits** — conventional format: `type(scope): subject`
   Scopes: `game`, `ui`, `ai`, `core`, `test`, `docs`
   Example: `feat(game): add collision detection for walls`

9. **Maven structure** — never put test files or properties in `src/main/java`

10. **Repository hygiene** — `target/`, `.idea/`, `.settings/`, `.classpath` are gitignored

## Development Workflow (Human-in-the-Loop)

1. Understand the task — read relevant UML diagrams in the Wiki
2. Claude suggests implementation → **human reviews and understands it**
3. Run `mvn clean verify` — all checks must pass
4. Commit only code you can explain in your own words
5. Push to GitHub

## Code Quality Gates

Run before every commit:
```bash
mvn clean verify
```

This executes in order:
- Compile
- JUnit 5 tests (Surefire)
- CheckStyle (Google Java Style)
- PMD (pmd-custom-ruleset.xml)
- SpotBugs

## Agents

See `.claude/AGENTS_README.md` for the agent team documentation.

## Imported Rules

@import .claude/rules/java-conventions.md
@import .claude/rules/testing.md

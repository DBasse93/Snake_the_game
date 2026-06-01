# Project Development Guide

## Quick Reference

| Item | Value |
|------|-------|
| **Project** | Snake_the_game |
| **Language** | java |
| **Architecture** | mvc |
| **Database** | none |
| **Main Branch** | main |
| **Test Command** | `mvn test` |
| **Lint Command** | `` |

## Architecture

Pattern: **mvc**
Source root: `src/main/java`
Test root: `src/test/java`

<!-- TODO: Document your architecture layers and patterns here -->

## Code Standards

- Follow java community best practices
- Run lint before every commit
- All new code must have tests
- Git commits: `type(scope): subject` (conventional format)
- NO AI/tool references in commit messages

## Key Rules

<!-- TODO: Add your project's critical rules here -->
<!-- These survive context compaction and are always visible -->

1. Follow the architecture pattern defined above
2. Use parameterized queries for all database operations
3. Run lint before every commit

## Agents

See `.claude/AGENTS_README.md` for the agent team documentation.

## Development Workflow

1. Check current branch and status
2. Implement changes following architecture pattern
3. Run tests: `mvn test`
4. Run lint: ``
5. Commit with conventional format

## Imported Rules

@import .claude/rules/java-conventions.md
@import .claude/rules/testing.md

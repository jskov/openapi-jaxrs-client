CollisionA and Collisiona will conflict on filesystems that are not case sensitive (such as on Windows).

Test renaming of DTOs to avoid on-disk conflict of names.

Conflicts are resolved using schema name order.

In this test, this means that CollisionA should keep its name (CollisionA
sorts before Collisiona) and then Collisiona should be renamed to CollisionaX
to avoid collision on-disk.

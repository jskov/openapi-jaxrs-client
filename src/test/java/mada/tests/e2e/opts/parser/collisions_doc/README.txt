CollisionA and Collisiona will conflict on filesystems that are not case sensitive (such as on Windows).

Test renaming of DTOs to avoid on-disk conflict of names.

Conflicts are resolved using schema declaration order in the OpenApi document.

In this test, this means that Collisiona should keep its name (first in
document) and then CollisionA should be renamed to CollisionAX to avoid
collision on-disk.

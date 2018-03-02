# My Fitness Routines
Android app to guide you through fitness routines.

## Steps to release
1. File Changes
    - **TODO.txt** up to date
    - Commit these on *master*:
        - Debug in **Debug.java**
            - *Debug.logLevel = LOG.INFO;*
            - *Debug.on = false;*
        - Version in Module's **build.gradle**
            - *versionCode* incremented (every App Store submission must be higher)
            - *versionString* (what's displayed to users)
        - Generate Signed APK
        - comment = *versionCode #2 = "0.4-beta"*
1. Publish GitHub Release
    - Attach APK(s)
    - v0.4.1-beta-feature
    - Mark it as *pre-release*
1. Upload to App Store

## Object-Oriented Design
- Routine
    - name
    - description
    - category
    - tasks
    - getDuration()
- Task
    - move
    - moveSeconds
    - restSeconds
- Move (MoveWithPose, LadderMove, SoccerMove)
    - name
    - description
    - category
    - twoSides
    - Poses or other drawables
    - getBitmap()
- Pose
    - torso
    - rLeg
    - lLeg
    - rArm
    - lArm
    - prop
- Log
    - Session
        - Date
        - Routine Name
        - Duration

# My Fitness Routines
Android app to guide you through fitness routines.

## Steps to release
1. TODO up to date
1. Gererate Signed APK
1. Commit to *master*
1. Publish Release
   - Attach APK(s)
   - v0.1.2-alpha-feature

## OOD
- Routine
  - name
  - description
  - category
  - steps
  - getDuration()
- Step
  - move
  - moveDuration
  - restDuration
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

# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.8

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CMake.app/Contents/bin/cmake

# The command to remove a file.
RM = /Applications/CMake.app/Contents/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code/bin

# Include any dependencies generated for this target.
include CMakeFiles/class5.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/class5.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/class5.dir/flags.make

CMakeFiles/class5.dir/main.cpp.o: CMakeFiles/class5.dir/flags.make
CMakeFiles/class5.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code/bin/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/class5.dir/main.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/class5.dir/main.cpp.o -c /Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code/main.cpp

CMakeFiles/class5.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/class5.dir/main.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code/main.cpp > CMakeFiles/class5.dir/main.cpp.i

CMakeFiles/class5.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/class5.dir/main.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code/main.cpp -o CMakeFiles/class5.dir/main.cpp.s

CMakeFiles/class5.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/class5.dir/main.cpp.o.requires

CMakeFiles/class5.dir/main.cpp.o.provides: CMakeFiles/class5.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/class5.dir/build.make CMakeFiles/class5.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/class5.dir/main.cpp.o.provides

CMakeFiles/class5.dir/main.cpp.o.provides.build: CMakeFiles/class5.dir/main.cpp.o


# Object files for target class5
class5_OBJECTS = \
"CMakeFiles/class5.dir/main.cpp.o"

# External object files for target class5
class5_EXTERNAL_OBJECTS =

class5: CMakeFiles/class5.dir/main.cpp.o
class5: CMakeFiles/class5.dir/build.make
class5: CMakeFiles/class5.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code/bin/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable class5"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/class5.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/class5.dir/build: class5

.PHONY : CMakeFiles/class5.dir/build

CMakeFiles/class5.dir/requires: CMakeFiles/class5.dir/main.cpp.o.requires

.PHONY : CMakeFiles/class5.dir/requires

CMakeFiles/class5.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/class5.dir/cmake_clean.cmake
.PHONY : CMakeFiles/class5.dir/clean

CMakeFiles/class5.dir/depend:
	cd /Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code/bin && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code /Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code /Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code/bin /Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code/bin /Users/josepereira/src/univ/programs/curso-miei/3/cg/p-05/code/bin/CMakeFiles/class5.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/class5.dir/depend


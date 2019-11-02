# TimeAnalysis
This Library is about getting 'Average of Time'. You just need to pass different times(in 12h format) and it will return the average in the string format.

# Gradle

Step 1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.elgobyte:LibraryBase:v1.0.0'
	}

# Usage

Add timings to an array
	
	ArrayList<String> timings = new ArrayList<>();

	timings.add("10:00 AM);
	timings.add("11:00 AM);

After adding, call this method and pass timings array to it.
	
	TimeAnalysis obj = new TimeAnalysis();
	obj.getAverage(ArrayList<String> timings);


# Output
It will return this
	
	10:30 AM // String value

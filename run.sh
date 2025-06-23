#!/bin/bash

# Student Grade Management System - Run Script
echo "🎓 Student Grade Management System"
echo "=================================="

# Set Java path
export PATH="/usr/local/opt/openjdk/bin:$PATH"

# Check if Java is available
if ! command -v java &> /dev/null; then
    echo "❌ Java not found. Please install Java JDK."
    exit 1
fi

# Compile Java files
echo "📦 Compiling Java files..."
if javac *.java; then
    echo "✅ Compilation successful!"
else
    echo "❌ Compilation failed!"
    exit 1
fi

# Run the application
echo "🚀 Starting application..."
java StudentGradeGUI

echo "👋 Application closed." 
/*
 * File:   InternalMergeSort.h
 * Created by Yufen Wang.
 * 2016
 */

#ifndef INTERNALMERGESORT_H
#define INTERNALMERGESORT_H
#pragma once

#include "stdafx.h"
#include "global.h"

namespace inf2b
{
    class InternalMergeSort
    {
    private:
        InputVectorType& m_input;
        bool m_debug = false;
        static long m_checkpoint;
        std::chrono::time_point< std::chrono::high_resolution_clock > start_time, end_time;

        void merge( int head, int middle, int rear );
        void mergeSort( int head, int rear );

    public:
        InternalMergeSort( InputVectorType& in ) : m_input( in ) {}
        InternalMergeSort( InputVectorType& in, bool debug) : m_input( in ), m_debug( debug ) {}
        virtual ~InternalMergeSort() {}
        InputVectorType operator()();

        static std::string getCheckpoints(){
          //std::cout << "[CHECKPOINT1]\t" << std::to_string(m_checkpoint/1000) << std::endl;
          return std::to_string(m_checkpoint/1000);

        };
    };
}

#endif

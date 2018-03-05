#ifndef PRIORITYQUEUE_H
#define PRIORITYQUEUE_H

#pragma once
#include "stdafx.h"
#include "global.h"
#include "Algorithm.h"

namespace inf2b{

      class PriorityQueue
      {
      private:
          long m_cursor;
          long m_last_index;
          long m_test_removeMax;
          bool m_insertOP;
          bool m_removeMaxOP;
          long m_dataElement;
          InputVectorType& m_input;

          void buildHeap();

          void hsort();

          void heapify( long nodeIndex );

          bool hasLeftChild( long nodeIndex );
          bool hasRightChild( long nodeIndex );
          long getLeftChild( long index );
          long getRightChild( long index );
          long getParent( long index );

          void swap( long indexX, long indexY );

          long removeMax();
          void insertElement(long element);

      public:
          //int execute(int a);
          PriorityQueue( InputVectorType& v, bool insertOP, bool removeMaxOP, long dataElement) : m_cursor( 0 ), m_input( v ), m_insertOP( insertOP ), m_removeMaxOP ( removeMaxOP ), m_dataElement(dataElement) {}
          ~PriorityQueue() {}

          long operator()();
      };
  }

  #endif

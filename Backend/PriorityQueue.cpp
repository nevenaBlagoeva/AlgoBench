#include "PriorityQueue.h"
#include "Heapsort.h"
using namespace inf2b;




void PriorityQueue::buildHeap()
{
    // start from the rightmost h-1 level node
    std::cout << "[UPDATE]\tBuilding heap..." << std::endl;
    std::cout << "[TASKRUNNER] Building heap..." << std::endl;
    int height = log2( m_input.size() );
    //std::cout << "[TREEHEIGHT]\t" << height << std::endl;
    long startNodeIndex = ( int ) pow( 2.0, height ) - 2;
    do {
        // heapify this subtree
        heapify( startNodeIndex );
    } while ( --startNodeIndex >= 0 );
}

void PriorityQueue::hsort()
{
    std::cout << "[UPDATE]\tSorting..." << std::endl;
    std::cout << "[TASKRUNNER] Executing Heap sort..." << std::endl;
    while ( m_cursor < ( m_input.size() - 1 ) ) {
        // exchange first and last elements
        swap( 0, m_input.size() - m_cursor - 1 );
        ++m_cursor;
        heapify( 0 );
    }

    int prev = 0;
    for ( auto n : m_input ) {
        assert( prev <= n );
        prev = n;
    }
}

void PriorityQueue::heapify( long nodeIndex )
{
    long maxValue = nodeIndex;
    long left = getLeftChild( nodeIndex );
    long right = getRightChild( nodeIndex );
    if ( hasLeftChild( nodeIndex ) && m_input[ left ] > m_input[ nodeIndex ] ) {
        maxValue = left;
    }
    if ( hasRightChild( nodeIndex ) && m_input[ right ] > m_input[ maxValue ] ) {
        maxValue = right;
    }
    if ( nodeIndex != maxValue ) {
        swap( nodeIndex, maxValue );
        heapify( maxValue );
    }
}

bool PriorityQueue::hasLeftChild( long nodeIndex )
{
    return ( getLeftChild( nodeIndex ) < ( m_input.size() - m_cursor ) );
}

bool PriorityQueue::hasRightChild( long nodeIndex )
{
    return (getRightChild( nodeIndex ) < ( m_input.size() - m_cursor ) );
}

long PriorityQueue::getLeftChild( long index )
{
    // multiply by 2
    return ( ( index << 1 ) + 1 );
}

long PriorityQueue::getRightChild( long index )
{
    return ( ( index << 1 ) + 2 );
}

long PriorityQueue::getParent( long index )
{
    return ( ( index - 1 ) >> 1 );
}

void PriorityQueue::swap( long indexX, long indexY )
{
    auto temp = m_input[ indexX ];
    m_input[ indexX ] = m_input[ indexY ];
    m_input[ indexY ] = temp;
}

/*

*/


long PriorityQueue::removeMax()
{
    long max = m_input[0];
    m_input[0] = m_input[m_last_index];
    m_input[m_last_index] = -1;
    m_last_index --;
    heapify(0);

    // for ( auto n : m_input )
    // {
    //     std::cout<<n<<std::endl;
    // }

    return max;
}

void PriorityQueue::insertElement(long e)
{
    m_last_index++;
    m_input[m_last_index] = e;
    long pointer_element = m_last_index;
    long pointer_parent = getParent(pointer_element);
    while(m_input[pointer_parent]<e)
    {
      swap(pointer_parent,pointer_element);

      if(pointer_parent==0) break;

      pointer_element = pointer_parent;
      pointer_parent = getParent(pointer_element);

    }
}
long PriorityQueue::operator()(){
    /* timing insertion and basic operations */
    std::chrono::time_point< std::chrono::high_resolution_clock > start_time, end_time;
    long m_output=0;
    m_last_index = m_input.size() - 2;

    buildHeap();

    if (m_removeMaxOP){
      // the empty box is -1 (for insertion)
      m_input[m_last_index+1] = -1;
      for(int i=0;i<100000;i++){
        start_time = std::chrono::high_resolution_clock::now();
        removeMax();
        end_time = std::chrono::high_resolution_clock::now();
        m_output+=std::chrono::duration_cast<std::chrono::nanoseconds>(end_time-start_time).count();
      }

    } if (m_insertOP){
        start_time = std::chrono::high_resolution_clock::now();
        insertElement(m_dataElement);
        end_time = std::chrono::high_resolution_clock::now();
        m_output=std::chrono::duration_cast<std::chrono::nanoseconds>(end_time - start_time).count();
    }

    // report time
    return m_output;

};

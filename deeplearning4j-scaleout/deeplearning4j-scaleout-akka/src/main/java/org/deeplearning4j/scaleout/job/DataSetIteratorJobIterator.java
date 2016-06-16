/*
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */

package org.deeplearning4j.scaleout.job;

import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

/**
 * Created by agibsonccc on 11/27/14.
 */
public class DataSetIteratorJobIterator implements JobIterator {
    protected DataSetIterator iter;

    public DataSetIteratorJobIterator(DataSetIterator iter) {
        this.iter = iter;
    }

    @Override
    public Job next(String workerId) {
        return new Job(iter.next(),workerId);
    }

    @Override
    public Job next() {
        return new Job(iter.next(),"");
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public void reset() {
        iter.reset();
    }
}
